package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {
    private final String countryName;
    private final BigDecimal numberOfCitizens;

    public Country(final String countryName, final BigDecimal numberOfCitizens) {
        this.countryName = countryName;
        this.numberOfCitizens = numberOfCitizens;
    }

    public String getCountryName() {
        return countryName;
    }

    public BigDecimal getPeopleQuantity() {
        return numberOfCitizens;
    }
}
