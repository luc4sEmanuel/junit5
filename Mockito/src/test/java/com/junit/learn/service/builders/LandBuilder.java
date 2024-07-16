package com.junit.learn.service.builders;

import com.junit.learn.models.Land;

public class LandBuilder {

    private String country;
    private String state;
    private String city;
    private String neighborhood;
    private String zipcode;
    private String address;

    private LandBuilder() {
    }

    public static LandBuilder getBuilder() {
        return new LandBuilder();
    }

    public LandBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public LandBuilder withState(String state) {
        this.state = state;
        return this;
    }

    public LandBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public LandBuilder withNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
        return this;
    }

    public LandBuilder withZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public LandBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public LandBuilder withGeneratedValues() {
        this.country = "BRASIL";
        this.state = "PARANÁ";
        this.city = "CURITIBA";
        this.neighborhood = "SAO BRAZ";
        this.zipcode = "82010270";
        this.address = "JOAO OBRZUT";
        return this;
    }

    public Land build() {
        return new Land(country, state, city, neighborhood, zipcode, address);
    }}
