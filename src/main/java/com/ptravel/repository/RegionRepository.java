package com.ptravel.repository;

import java.util.List;

import com.ptravel.pojos.Region;

public interface RegionRepository {
    public List<Region> getListRegion();
    public Region getRegionById(Integer regionId);
}
