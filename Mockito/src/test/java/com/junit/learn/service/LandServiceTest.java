package com.junit.learn.service;

import com.junit.learn.models.Land;
import com.junit.learn.repositories.LandRepository;
import com.junit.learn.service.builders.LandBuilder;
import com.junit.learn.services.LandService;
import com.junit.learn.services.impl.LandServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import java.util.List;

class LandServiceTest {

    private static final String BRASIL_COUNTRY= "BRASIL";
    private static final String PARANA_STATE= "PARANÁ";
    private static final String CURITIBA_CITY = "CURITIBA";

    @Test
    void shouldListLandsByNeighborhood(){
        final String neighborhood = "SAO BRAZ";

        LandRepository landRepository = mock(LandRepository.class);
        LandService landService = new LandServiceImpl(landRepository);
        final var landMockList = List.of(LandBuilder.getBuilder().withGeneratedValues().build());

        when(landRepository.listLandsByNeighborhood(BRASIL_COUNTRY, PARANA_STATE, CURITIBA_CITY, neighborhood)).thenReturn(landMockList);

        List<Land> landList = landService.listLandsByNeighborhood(BRASIL_COUNTRY, PARANA_STATE, CURITIBA_CITY, neighborhood);

        Assertions.assertThat(landList).isNotEmpty();
        landList.forEach(land -> {
            Assertions.assertThat(land.country()).isEqualTo(BRASIL_COUNTRY);
            Assertions.assertThat(land.state()).isEqualTo(PARANA_STATE);
            Assertions.assertThat(land.city()).isEqualTo(CURITIBA_CITY);
            Assertions.assertThat(land.neighborhood()).isEqualTo(neighborhood);
        });
    }

    @Test
    void shouldListLandsByCity(){
        final String neighborhood = "SAO BRAZ";

        LandRepository landRepository = mock(LandRepository.class);
        LandService landService = new LandServiceImpl(landRepository);

        final var landOne = new Land(BRASIL_COUNTRY, PARANA_STATE, CURITIBA_CITY, "CAJURU", "777", "Birds Wall");
        final var landTwo = new Land(BRASIL_COUNTRY, PARANA_STATE, CURITIBA_CITY, neighborhood, "8888", "Jonh Will");

        final var landMockList = List.of(landOne, landTwo);

        when(landRepository.listLandsByCity(BRASIL_COUNTRY,PARANA_STATE, CURITIBA_CITY)).thenReturn(landMockList);

        List<Land> landList = landService.listLandsByCity(BRASIL_COUNTRY, PARANA_STATE, CURITIBA_CITY);

        Assertions.assertThat(landList).isNotEmpty();
        landList.forEach(land -> {
            Assertions.assertThat(land.country()).isEqualTo(BRASIL_COUNTRY);
            Assertions.assertThat(land.state()).isEqualTo(PARANA_STATE);
            Assertions.assertThat(land.city()).isEqualTo(CURITIBA_CITY);
        });
    }

}

