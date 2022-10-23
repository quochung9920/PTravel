package com.ptravel.service;

import java.util.List;

import com.ptravel.pojos.Region;

public interface RegionService {
    public List<Region> getListRegion();
    public Region getRegionById(Integer regionId);
}
