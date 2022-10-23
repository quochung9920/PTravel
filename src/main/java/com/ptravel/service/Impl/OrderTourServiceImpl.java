package com.ptravel.service.Impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptravel.pojos.TourDetail;
import com.ptravel.pojos.TourOrder;
import com.ptravel.pojos.User;
import com.ptravel.repository.OrderTourRepository;
import com.ptravel.repository.TourRepository;
import com.ptravel.repository.UserRepository;
import com.ptravel.service.OrderTourService;

@Service
public class OrderTourServiceImpl implements OrderTourService {
    @Autowired
    private OrderTourRepository orderTourRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TourRepository tourRepository;

    @Override
    public TourOrder addOrderTour(Date date, int numberAdult, int numberChild, int totalPrice, int tourId, int userId) {
        User user = this.userRepository.getUserById(userId);

        TourDetail tour = this.tourRepository.getTourById(tourId);
        

        TourOrder orderTour = new TourOrder();
        orderTour.setDepartureDay(date);
        orderTour.setNumberAdult(numberAdult);
        orderTour.setNumberChildren(numberChild);
        orderTour.setTotalPrice(totalPrice);
        orderTour.setTourId(tour);
        orderTour.setUserId(user);
        orderTour.setActive(false);


        return this.orderTourRepository.addOrderTour(orderTour);
    }

    @Override
    public List<TourOrder> getAllOrderTour(boolean active) {
        return this.orderTourRepository.getAllOrderTour(active);
    }

    @Override
    public List<TourOrder> getAllOrderTourByUser(int userId, boolean active) {
        return this.orderTourRepository.getAllOrderTourByUser(userId, active);
    }

    @Override
    public List<TourOrder> getListOrderTour() {
        return this.orderTourRepository.getListOrderTour();
    }

    @Override
    public TourOrder updateOrderTour(int orderId) {
        return this.orderTourRepository.updateOrderTour(orderId);
    }

    @Override
    public boolean activeOrderTour(int orderId) {
        return this.activeOrderTour(orderId);
    }


    
}
