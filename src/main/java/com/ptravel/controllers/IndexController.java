package com.ptravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ptravel.pojos.TourDetail;
import com.ptravel.pojos.User;
import com.ptravel.service.TourService;
import com.ptravel.service.UserService;


@Controller
@PropertySource("classpath:messages.properties")
public class IndexController {
    @Autowired
    private TourService tourService;
    @Autowired
    private UserService userDetailsService;
    @Autowired
    private Environment env;

    @GetMapping("/")
    public String index(Model model, Authentication authentication) {

        List<TourDetail> tourDetails = this.tourService.getTours(1, Integer.parseInt(env.getProperty("page.size.inland")));
        for (TourDetail tourDetail : tourDetails) {
            tourDetail.setImage(tourDetail.getImage().split("/")[0]);
        }
        model.addAttribute("tour", tourDetails);

        List<TourDetail> toursSpring = this.tourService.getToursBySeason(1, Integer.parseInt(env.getProperty("page.size.season")));
        for (TourDetail tourDetail : toursSpring) {
            tourDetail.setImage(tourDetail.getImage().split("/")[0]);
        }

        List<TourDetail> toursSummer = this.tourService.getToursBySeason(2, Integer.parseInt(env.getProperty("page.size.season")));
        for (TourDetail tourDetail : toursSummer) {
            tourDetail.setImage(tourDetail.getImage().split("/")[0]);
        }

        List<TourDetail> toursAutumn = this.tourService.getToursBySeason(3, Integer.parseInt(env.getProperty("page.size.season")));
        for (TourDetail tourDetail : toursAutumn) {
            tourDetail.setImage(tourDetail.getImage().split("/")[0]);
        }

        List<TourDetail> toursWinter = this.tourService.getToursBySeason(4, Integer.parseInt(env.getProperty("page.size.season")));
        for (TourDetail tourDetail : toursWinter) {
            tourDetail.setImage(tourDetail.getImage().split("/")[0]);
        }

        model.addAttribute("tourSpring", toursSpring);
        model.addAttribute("tourSummer", toursSummer);
        model.addAttribute("tourAutumn", toursAutumn);
        model.addAttribute("tourWinter", toursWinter);

        try {
            User user = this.userDetailsService.getUsers(authentication.getName()).get(0);

            if(user.getUsername().isEmpty() == true){
                model.addAttribute("userId", "0");
            } else {
                model.addAttribute("userId", user.getId());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "index";
    }


    

}