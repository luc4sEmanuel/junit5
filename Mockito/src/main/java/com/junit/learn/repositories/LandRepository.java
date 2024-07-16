package com.junit.learn.repositories;

import com.junit.learn.models.Land;

import java.util.List;

public interface LandRepository {

    List<Land> listLandsByNeighborhood(final String country, final String  state, final String  city, final String  neighborhood);

    List<Land> listLandsByCity(final String country,final String  state,final String  city);
}
