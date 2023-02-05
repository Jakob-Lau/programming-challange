package de.bcxp.challenge;

import de.bcxp.challenge.countries.CountryAnalysis;
import de.bcxp.challenge.weather.WeatherAnalysis;

import java.io.File;
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
    public static void main(String... args) throws IOException {
        // create weather analysis
        String[] weatherPathArray = {"src", "main", "resources", "de", "bcxp", "challenge", "weather.csv"};
        final Path weatherPath = Paths.get(String.join(File.separator, weatherPathArray));
        WeatherAnalysis weatherAnalysis = new WeatherAnalysis(weatherPath, ',');

        // create countries analysis
        String[] countriesPathArray = {"src", "main", "resources", "de", "bcxp", "challenge", "countries.csv"};
        final Path countriesPath = Paths.get(String.join(File.separator, countriesPathArray));
        CountryAnalysis countryAnalysis = new CountryAnalysis(countriesPath, ';');


        // analysis calls
        int dayWithSmallestTempSpread = weatherAnalysis.calcSmallestTempSpread().day;
        System.out.printf("Day with smallest temperature spread: %d%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = countryAnalysis.getHighestPopulationDensityCountry().getName();
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
