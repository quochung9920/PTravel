package com.ptravel.service;

import java.util.List;
import java.util.Map;

import com.ptravel.pojos.TourDetail;

public interface TourService {
    List<TourDetail> getTours(int page, int size);
    // TourDetail addTour(String tourName,String header, String intro, String schedule, int priceAdult, int priceChild, int season, int region, String image1, String image2, String image3, String image4);
    TourDetail addTour(String tourName,String header, String intro, String schedule, int priceAdult, int priceChild, int season, int region);
    TourDetail getTourById(Integer tourId);
    boolean updateTour(TourDetail tour, Integer tourId);
    boolean deleteTour(Integer tourId);
    boolean updateTourImages(TourDetail tourDetail, Integer tourId);
    int countTours();

    List<TourDetail> getToursBySeason(int seasonId, int size);

    List<TourDetail> getTours(Map<String, String> params);
}
