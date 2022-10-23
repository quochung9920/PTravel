package com.ptravel.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

import com.ptravel.pojos.Region;
import com.ptravel.pojos.TourDetail;
import com.ptravel.pojos.TourOrder;
import com.ptravel.pojos.User;
import com.ptravel.service.OrderTourService;
import com.ptravel.service.RegionService;
import com.ptravel.service.SeasonService;
import com.ptravel.service.TourService;
import com.ptravel.service.UserService;

@Controller
public class AdminController {
    @Autowired
    private TourService tourService;
    @Autowired
    private UserService userDetailsService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private SeasonService seasonService;
    @Autowired
    private OrderTourService orderTourService;

    @RequestMapping("/admin")
    public String index() {
        return "admin-index";
    }

    @RequestMapping("/admin/tour-manager")
    public String tourView() {
        return "tour-manager";
    }

    @GetMapping("/admin/tour-manager/add-tour")
    public String tourCreateView(Model model) {
        model.addAttribute("tour", new TourDetail());
        
        model.addAttribute("region", this.regionService.getListRegion());
        model.addAttribute("season", this.seasonService.getListSeason());
        return "add-tour";
    }


    @GetMapping("/admin/update-tour/{tourId}")
    public String tourUpdateView(Model model, @PathVariable(value = "tourId") Integer tourId, 
        @ModelAttribute(value = "imageTour") TourDetail tourDetail) {
        TourDetail tour = this.tourService.getTourById(tourId);
        model.addAttribute("tour", tour);
        model.addAttribute("region", this.regionService.getListRegion());
        model.addAttribute("season", this.seasonService.getListSeason());

        return "update-tour";
    }

    // @PostMapping("/admin/update-tour/{tourId}")
    // public String tourUpdate(Model model, @ModelAttribute(value = "imageTour") TourDetail tourDetail,
    //     @PathVariable(value = "tourId") Integer tourId) {
    //     return "/admin/update-tour/" + tourId;
    // }



    @GetMapping("/admin/user-manager")
    public String userView() {
        return "user-manager";
    }

    @GetMapping("/admin/add-user")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleUser", User.USER);
        model.addAttribute("roleStaff", User.STAFF);

        return "add-user";
    }

    @PostMapping("/admin/add-user")
    public String register(Model model,
            @ModelAttribute(value = "user") User user) {
        String errMsg = "";

        if (user.getPassword().equals(user.getConfirmPassword()) || !user.getPassword().isEmpty()) {
            if (this.userDetailsService.addUser(user, user.getUserRole()) == true) {
                return "redirect:/admin/user-manager";
            } else {
                errMsg = "Please try again!";
            }
        } else {
            errMsg = "Password and Confirm Password not match";
        }

        model.addAttribute("errMsg", errMsg);

        return "add-user";
    }


    @GetMapping("/admin/update-user/{userId}")
    public String userUpdateView(Model model, @PathVariable(value = "userId") Integer userId, 
        @ModelAttribute(value = "imageUser") User user) {
        User userDetail = this.userDetailsService.getUserById(userId);
        model.addAttribute("user", userDetail);
        return "update-user";
    }

    @GetMapping("/admin/order-manager")
    public String orderView(Model model) {
        model.addAttribute("orderTourManager", this.orderTourService.getListOrderTour());
        return "order-manager";
    }


    @PostMapping("/admin/order-manager/{orderId}")
    public String activeOrderTour(@ModelAttribute(value = "activeOrderTour") TourOrder tourOrder,
        @PathVariable(value = "orderId") Integer orderId) {
        
        this.orderTourService.activeOrderTour(orderId);

        return "redirect:/admin/order-manager";
        
    }


    @PostMapping("/admin/update-tour/{tourId}")
    public String tourUpdate(@ModelAttribute(value = "tourUpdateImage") TourDetail tourDetail,
        @PathVariable(value = "tourId") Integer tourId) {
        

        this.tourService.updateTourImages(tourDetail, tourId);

        return "redirect:/admin/tour-manager";
    }


}
