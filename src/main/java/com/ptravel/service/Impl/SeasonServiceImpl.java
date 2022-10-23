package com.ptravel.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptravel.pojos.Season;
import com.ptravel.repository.SeasonRepository;
import com.ptravel.service.SeasonService;

@Service
public class SeasonServiceImpl implements SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    @Override
    public List<Season> getListSeason() {
        return this.seasonRepository.getListSeason();
    }

    @Override
    public Season getSeasonById(Integer seasonId) {
        return this.seasonRepository.getSeasonById(seasonId);
    }

   
    
}
