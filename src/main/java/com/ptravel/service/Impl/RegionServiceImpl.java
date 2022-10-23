package com.ptravel.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptravel.pojos.Region;
import com.ptravel.repository.RegionRepository;
import com.ptravel.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<Region> getListRegion() {
        return this.regionRepository.getListRegion();
    }

    @Override
    public Region getRegionById(Integer regionId) {
        return this.regionRepository.getRegionById(regionId);
    }

    
}
