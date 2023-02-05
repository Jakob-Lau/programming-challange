package de.bcxp.challenge.weather;

import de.bcxp.challenge.csv.CsvReader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WeatherAnalysis {

    private List<Weather> data;

    public WeatherAnalysis(Path path, char separator) throws IOException {
        this.readData(path, separator);
    }

    public Weather calcSmallestTempSpread() {
        WeatherTempSpreadComparator weatherComparator = new WeatherTempSpreadComparator();
        List<Weather> copy = new ArrayList<>(List.copyOf(this.data));
        copy.sort(weatherComparator);
        return copy.get(data.size() - 1);
    }

    public void setData(List<Weather> data) {
        this.data = data;
    }

    private void readData(Path path, char separator) throws IOException {
        this.data = new CsvReader<Weather>().readFile(path, separator, Weather.class);
    }
}
