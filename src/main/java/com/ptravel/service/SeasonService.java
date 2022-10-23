package com.ptravel.service;

import java.util.List;

import com.ptravel.pojos.Season;

public interface SeasonService {
    public List<Season> getListSeason();
    public Season getSeasonById(Integer seasonId);
}
