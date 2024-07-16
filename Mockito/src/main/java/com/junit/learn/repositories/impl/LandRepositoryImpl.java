package com.junit.learn.repositories.impl;

import com.junit.learn.models.Land;
import com.junit.learn.repositories.LandRepository;

import java.util.List;

public class LandRepositoryImpl implements LandRepository {
    @Override
    public List<Land> listLandsByNeighborhood(String country, String state, String city, String neighborhood) {
        return List.of();
    }

    @Override
    public List<Land> listLandsByCity(String country, String state, String city) {
        return List.of();
    }
}
