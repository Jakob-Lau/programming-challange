package de.bcxp.challenge;

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
    public static void main(String... args) throws IOException {
        final Path weatherPath = Paths.get("src/main/resources/de/bcxp/challenge/weather.csv");
        WeatherAnalysis weatherAnalysis = new WeatherAnalysis(weatherPath, ',');

        // Your preparation code …

        // Your preparation code

        int dayWithSmallestTempSpread = weatherAnalysis.calcSmallestTempSpread().day;
        System.out.printf("Day with smallest temperature spread: %d%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
