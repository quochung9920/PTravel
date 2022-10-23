package com.ptravel.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptravel.service.OrderTourService;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private OrderTourService orderTourService;

    @GetMapping("")
    public String cartView(Model model, @RequestParam(value = "user") Integer userId) {
        model.addAttribute("orderTourByUserWaiting", this.orderTourService.getAllOrderTourByUser(userId, false));
        model.addAttribute("orderTourByUserActive", this.orderTourService.getAllOrderTourByUser(userId, true));
        return "cart";
    }


}
