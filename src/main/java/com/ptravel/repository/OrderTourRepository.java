package com.ptravel.repository;

import java.util.List;

import com.ptravel.pojos.TourOrder;

public interface OrderTourRepository {
    public TourOrder addOrderTour(TourOrder orderTour);
    public List<TourOrder> getListOrderTour();
    public List<TourOrder> getAllOrderTour(boolean active);
    public List<TourOrder> getAllOrderTourByUser(int userId, boolean active);
    public TourOrder updateOrderTour(int orderId);
}
