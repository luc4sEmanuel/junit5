package com.junit.learn.services.impl;

import com.junit.learn.models.Land;
import com.junit.learn.repositories.LandRepository;
import com.junit.learn.services.LandService;

import java.util.List;

public class LandServiceImpl implements LandService {

    private final LandRepository landRepository;

    public LandServiceImpl(final LandRepository landRepository ){
        this.landRepository = landRepository;
    }

    @Override
    public List<Land> listLandsByNeighborhood(String country, String state, String city, String neighborhood) {
        return landRepository.listLandsByNeighborhood(country, state, city, neighborhood);
    }

    @Override
    public List<Land> listLandsByCity(String country, String state, String city) {
        return landRepository.listLandsByCity(country, state, city);
    }
}
