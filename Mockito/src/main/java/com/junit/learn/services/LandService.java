package com.junit.learn.services;

import com.junit.learn.models.Land;

import java.util.List;

public interface LandService {

    List<Land> listLandsByNeighborhood(final String country,final String  state,final String  city, final String  neighborhood);

    List<Land> listLandsByCity(final String country,final String  state,final String  city);

}
