package com.ptravel.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptravel.pojos.TourOrder;
import com.ptravel.pojos.User;
import com.ptravel.service.OrderTourService;
import com.ptravel.service.UserService;

@RestController
public class ApiOrderTourController {
    @Autowired
    private OrderTourService orderTourService;
    @Autowired
    private UserService userDetailService;

    @PostMapping(path="/api/tours/{tourId}/order-tour", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<TourOrder> addOrderTour(@PathVariable("tourId") int tourId,
        @RequestBody Map<String, String> params, Authentication authentication){
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(params.getOrDefault("departureDay", ""));
            int numberAdult = Integer.parseInt(params.get("numberAdult"));
            int numberChild = Integer.parseInt(params.get("numberChild"));
            int totalPrice = Integer.parseInt(params.get("totalPrice"));
            User user = this.userDetailService.getUsers(authentication.getName()).get(0);
            TourOrder orderTour = this.orderTourService.addOrderTour(date, numberAdult, numberChild, totalPrice, tourId, user.getId());
            return new ResponseEntity<TourOrder>(orderTour, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println("Lỗi rồi" + ex.getMessage());
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(path="/api/update-order/{orderId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<TourOrder> addUpdateTour(@PathVariable("orderId") int orderId, @RequestBody Map<String, String> params){
        try {
            TourOrder orderTour = this.orderTourService.updateOrderTour(orderId);
            return new ResponseEntity<TourOrder>(orderTour, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Lỗi rồi" + ex.getMessage());
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  

}
