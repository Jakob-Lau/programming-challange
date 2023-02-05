package de.bcxp.challenge.countries;

import de.bcxp.challenge.csv.CsvReader;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Setter
public class CountryAnalysis {

    private List<Country> data;

    public CountryAnalysis(Path path, char separator) throws IOException {
        this.readData(path, separator);
    }

    public Country getHighestPopulationDensityCountry() {
        CountryPopulationDensityComparator comparator = new CountryPopulationDensityComparator();
        List<Country> copy = new java.util.ArrayList<>(List.copyOf(this.data));
        copy.sort(comparator);
        return copy.get(copy.size() - 1);
    }

    private void readData(Path path, char separator) throws IOException {
        this.data = new CsvReader<Country>().readFile(path, separator, Country.class);
    }
}
