package com.ptravel.service.Impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ptravel.pojos.Region;
import com.ptravel.pojos.Season;
import com.ptravel.pojos.TourDetail;
import com.ptravel.repository.TourRepository;
import com.ptravel.service.RegionService;
import com.ptravel.service.SeasonService;
import com.ptravel.service.TourService;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private SeasonService seasonService;
    @Autowired
    private RegionService regionService;

    @Autowired
    private Cloudinary cloudinary;

    private static String UPLOADED_FOLDER = "C://Users//quoch//Desktop//ptravel//src//main//webapp//resources//images//image-tour//";




    @Override
    public List<TourDetail> getTours(int page, int size) {
        return this.tourRepository.getTours(page, size);
    }

    @Override
    public TourDetail addTour(String tourName, String header, String intro, String schedule, int priceAdult, int priceChild, int season, int region) {

        Season seasonObj = this.seasonService.getSeasonById(season);
        Region regionObj = this.regionService.getRegionById(region);


        TourDetail tour = new TourDetail();
        tour.setTourName(tourName);
        tour.setHeader(header);
        tour.setIntro(intro);
        tour.setSchedule(schedule);
        tour.setPriceAdult(priceAdult);
        tour.setPriceChild(priceChild);
        tour.setSeasonId(seasonObj);
        tour.setRegionId(regionObj);
        
        return this.tourRepository.addTour(tour);
    }

    @Override
    public TourDetail getTourById(Integer tourId) {
        return this.tourRepository.getTourById(tourId);
    }

    @Override
    public boolean updateTour(TourDetail tour, Integer tourId) {

        return this.tourRepository.updateTour(tour, tourId);
    }

    @Override
    public boolean deleteTour(Integer tourId) {
        return this.tourRepository.deleteTour(tourId);
    }

    @Override
    public boolean updateTourImages(TourDetail tourDetail, Integer tourId) {
        String imageList = "";
        try {
            for (MultipartFile file : tourDetail.getImageTour()) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                imageList += file.getOriginalFilename() + "/";
            }

            return this.tourRepository.updateTourImages(tourId, imageList);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int countTours() {
        return this.tourRepository.countTours();
    }

    @Override
    public List<TourDetail> getToursBySeason(int seasonId, int size) {
        return this.tourRepository.getToursBySeason(seasonId, size);
    }

    @Override
    public List<TourDetail> getTours(Map<String, String> params) {
        
        return this.tourRepository.getTours(params);
    }
}
