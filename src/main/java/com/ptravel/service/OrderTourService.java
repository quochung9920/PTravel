package com.ptravel.service;

import java.util.Date;
import java.util.List;

import com.ptravel.pojos.TourOrder;

public interface OrderTourService {
    TourOrder addOrderTour(Date date, int numberAdult, int numberChild, int totalPrice, int tourId, int userId);

    List<TourOrder> getListOrderTour();

    List<TourOrder> getAllOrderTour(boolean active);

    List<TourOrder> getAllOrderTourByUser(int userId, boolean active);

    TourOrder updateOrderTour(int orderId);

    boolean activeOrderTour(int orderId);
}
