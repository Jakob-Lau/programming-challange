package de.bcxp.challenge.countries;

import java.util.Comparator;

public class CountryPopulationDensityComparator implements Comparator<Country> {

    @Override
    public int compare(Country c1, Country c2) {
        return Float.compare(c1.getPopulationDensity(), c2.getPopulationDensity());
    }
}
