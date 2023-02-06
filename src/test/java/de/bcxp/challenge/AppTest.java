package de.bcxp.challenge;

import de.bcxp.challenge.csv.CsvReader;
import de.bcxp.challenge.weather.Weather;
import de.bcxp.challenge.weather.WeatherTempSpreadComparator;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Example JUnit 5 test case.
 */
class AppTest {

    @Test
    void testCsvReader() {
        Path wrongPath = Paths.get("this/path/does/not/exist.csv");
        CsvReader<String> csvReader = new CsvReader<>();
        Throwable exception = assertThrows(FileNotFoundException.class, () -> csvReader.readFile(wrongPath, ',', String.class));
        assertEquals("File " + wrongPath.toFile().getAbsolutePath() + " not found.", exception.getMessage());
    }

    @Test
    void testWeather() {
        Weather weather = new Weather(0, 14, 12);
        // test if the values are set correct
        assertEquals(14, weather.getMaxTemp());
        assertEquals(12, weather.getMinTemp());
        // test if maxTemp and minTemp are swapped if the given maxTemp is less than the current minTemp
        weather.setMaxTemp(10);
        assertEquals(12, weather.getMaxTemp(), "Values are not correctly sanitized");
        assertEquals(10, weather.getMinTemp(), "Values are not correctly sanitized");
        // test if minTemp is swapped too
        weather.setMinTemp(14);
        assertEquals(14, weather.getMaxTemp());
        assertEquals(12, weather.getMinTemp());

        // test if maxTemp and minTemp are swapped in constructor
        Weather weather1 = new Weather(0, 12, 14);
        assertEquals(14, weather1.getMaxTemp());
        assertEquals(12, weather1.getMinTemp());
    }

    /**
     * you could split it in 3 different tests
     */
    @Test
    void testWeatherTempSpreadComparator() {
        Weather weather1;
        Weather weather2;
        int compareResult;
        WeatherTempSpreadComparator comparator = new WeatherTempSpreadComparator();

        // test equal
        weather1 = new Weather(0, 10, 0);
        weather2 = new Weather(0, 20, 10);
        compareResult = comparator.compare(weather1, weather2);
        assertEquals(0, compareResult, "expected to be equal");

        // test greater than
        weather1 = new Weather(0, 20, 0);
        weather2 = new Weather(0, 10, 0);
        compareResult = comparator.compare(weather1, weather2);
        assertTrue(compareResult >= 1, "expected to be greater than");

        // test less than
        weather1 = new Weather(0, 10, 0);
        weather2 = new Weather(0, 20, 0);
        compareResult = comparator.compare(weather1, weather2);
        assertTrue(compareResult <= 1, "expected to be less than");
    }

}