package com.ptravel.repository;

import java.util.List;

import com.ptravel.pojos.Season;

public interface SeasonRepository {
    public List<Season> getListSeason();
    public Season getSeasonById(Integer seasonId);
}
