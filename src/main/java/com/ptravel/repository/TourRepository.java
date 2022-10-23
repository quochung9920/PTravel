package com.ptravel.repository;

import java.util.List;
import java.util.Map;

import com.ptravel.pojos.TourDetail;

public interface TourRepository {
    TourDetail addTour(TourDetail tour);
    List<TourDetail> getTours(int page, int size);
    TourDetail getTourById(Integer tourId);
    boolean updateTour(TourDetail tour, Integer tourId);
    boolean deleteTour(Integer tourId);
    boolean updateTourImages(TourDetail tourDetail, Integer tourId);
    int countTours();
    List<TourDetail> getToursBySeason(int seasonId, int size);
    boolean activeOrderTour(int orderId);
    boolean updateTourImages(int tourId, String imageList);
    List<TourDetail> getTours(Map<String, String> params);
}
