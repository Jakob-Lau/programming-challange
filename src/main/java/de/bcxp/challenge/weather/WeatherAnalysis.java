package de.bcxp.challenge.weather;

import de.bcxp.challenge.csv.CsvReader;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Setter
public class WeatherAnalysis {

    private List<Weather> data;

    public WeatherAnalysis(Path path, char separator) throws IOException {
        this.readData(path, separator);
    }

    public Weather calcSmallestTempSpread() {
        WeatherTempSpreadComparator weatherComparator = new WeatherTempSpreadComparator();
        return this.data.stream().min(weatherComparator).get();
    }

    private void readData(Path path, char separator) throws IOException {
        this.data = new CsvReader<Weather>().readFile(path, separator, Weather.class);
    }
}
