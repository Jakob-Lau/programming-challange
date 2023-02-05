package de.bcxp.challenge.countries;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @CsvBindByName(column = "Name", required = true)
    private String name;

    @CsvBindByName(column = "Capital")
    private String capital;

    @CsvBindByName(column = "Population", required = true)
    private long population;

    @CsvBindByName(column = "Area (km²)", required = true)
    private long area;

    /**
     * calculate population density
     * @return population density in population per square kilometer
     */
    public float getPopulationDensity() {
        return (float) population / area;
    }

    public String toString() {
        return this.name + ";" + this.capital + ";" + this.population + ";" + this.area;
    }
}
