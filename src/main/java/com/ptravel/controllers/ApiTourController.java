package com.ptravel.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RestController;

import com.ptravel.pojos.Province;
import com.ptravel.pojos.Season;
import com.ptravel.pojos.TourDetail;
import com.ptravel.service.RegionService;
import com.ptravel.service.SeasonService;
import com.ptravel.service.TourService;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api")
@PropertySource("classpath:messages.properties")
public class ApiTourController {
    @Autowired
    private TourService tourService;
    @Autowired
    private SeasonService seasonService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private Environment env;
    
    @GetMapping("/tours")
    public ResponseEntity<List<TourDetail>> listTours() {
        return new ResponseEntity<>(this.tourService.getTours(0, this.tourService.countTours()), HttpStatus.OK);
    }

    @PostMapping(path="/tours/add-tour", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<TourDetail> addTour(@RequestBody Map<String, String> params){
        try {
            String tourName = params.getOrDefault("tourName", "");
            String header = params.getOrDefault("header", "");
            String intro = params.getOrDefault("intro", "");
            String schedule = params.getOrDefault("schedule", "");
            int priceAdult = Integer.parseInt(params.getOrDefault("priceAdult", ""));
            int priceChild = Integer.parseInt(params.getOrDefault("priceChild", ""));
            int season = Integer.parseInt(params.get("season"));
            int region = Integer.parseInt(params.get("region"));
            // String image1 = params.getOrDefault("image1", "");
            // String image2 = params.getOrDefault("image2", "");
            // String image3 = params.getOrDefault("image3", "");
            // String image4 = params.getOrDefault("image4", "");


            // TourDetail tour = this.tourService.addTour(tourName, header, intro, schedule, priceAdult, priceChild, season, region, image1, image2, image3, image4);
            TourDetail tour = this.tourService.addTour(tourName, header, intro, schedule, priceAdult, priceChild, season, region);
            return new ResponseEntity<TourDetail>(tour, HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PutMapping(path = "/tours/{tourId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<TourDetail> updateTour(@PathVariable(value = "tourId") Integer tourId, @RequestBody Map<String, String> params) {
        
        try {
            TourDetail tour = new TourDetail();
            tour.setId(tourId);
            tour.setHeader(params.getOrDefault("header", ""));
            tour.setIntro(params.getOrDefault("intro", ""));
            tour.setSchedule(params.getOrDefault("schedule", ""));
            tour.setPriceAdult(Integer.parseInt(params.getOrDefault("priceAdult", "")));
            tour.setPriceChild(Integer.parseInt(params.getOrDefault("priceChild", "")));
            tour.setSeasonId(this.seasonService.getSeasonById(Integer.parseInt(params.get("season"))));
            tour.setRegionId(this.regionService.getRegionById(Integer.parseInt(params.get("region"))));
            tour.setTourName(params.getOrDefault("tourName", ""));
            // tour.setImage1(params.getOrDefault("image1", ""));
            // tour.setImage2(params.getOrDefault("image2", ""));
            // tour.setImage3(params.getOrDefault("image3", ""));
            // tour.setImage4(params.getOrDefault("image4", ""));

            this.tourService.updateTour(tour, tourId);
            return new ResponseEntity<>(tour, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    
    @DeleteMapping("/tours/{tourId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTour(@PathVariable(value = "tourId") int tourId) {
        this.tourService.deleteTour(tourId);
    }

}
