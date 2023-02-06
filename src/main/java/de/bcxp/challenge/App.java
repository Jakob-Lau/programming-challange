package de.bcxp.challenge;

import de.bcxp.challenge.countries.CountryAnalysis;
import de.bcxp.challenge.weather.WeatherAnalysis;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        // analysis calls
        String dayWithSmallestTempSpread = getDayWithSmallestTemperatureSpread();
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = getHighestPopulationDensityCountry();
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }

    private static String getDayWithSmallestTemperatureSpread() {
        try {
            final Path weatherPath = Paths.get("src/main/resources/de/bcxp/challenge/weather.csv");
            // get analysis class
            WeatherAnalysis weatherAnalysis = new WeatherAnalysis(weatherPath, ',');
            return String.valueOf(weatherAnalysis.calcSmallestTempSpread().day);
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    private static String getHighestPopulationDensityCountry() {
        try {
            final Path countriesPath = Paths.get("src/main/resources/de/bcxp/challenge/countries.csv");
            // get analysis class
            CountryAnalysis countryAnalysis = new CountryAnalysis(countriesPath, ';');
            return  countryAnalysis.getHighestPopulationDensityCountry().getName();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
