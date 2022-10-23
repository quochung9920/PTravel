package com.ptravel.controllers;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptravel.pojos.TourDetail;
import com.ptravel.service.TourService;

@Controller
public class TourController {
    @Autowired
    private TourService tourService;

    @GetMapping("/{tourId}")
    public String tour(Model model,
        @PathVariable(value = "tourId") Integer tourId) {
        
        TourDetail tour = this.tourService.getTourById(tourId);
        String[] images = tour.getImage().split("/");
        String[] images2 = Arrays.copyOfRange(images, 1, images.length);

        model.addAttribute("tour", tour);
        model.addAttribute("imageTop", images[0]);
        model.addAttribute("imagesTour", images2);


        return "tour-detail";
    }

    @GetMapping("/tour-list")
    public String tourList(Model model,
        @RequestParam Map<String, String> params,
        HttpSession session) {
        List<TourDetail> tourDetails = this.tourService.getTours(params);
        for (TourDetail tourDetail : tourDetails) {
            tourDetail.setImage(tourDetail.getImage().split("/")[0]);
        }
        model.addAttribute("tours", tourDetails);
        return "tour-list";
    }
}
