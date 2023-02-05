package de.bcxp.challenge.weather;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;

@Getter
public class Weather {

    @CsvBindByName(column = "Day")
    public final int day;

    @CsvBindByName(column = "MxT")
    private int maxTemp;

    @CsvBindByName(column = "MnT")
    private int minTemp;

    public Weather(int day, int maxTemp, int minTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.sanitizeValues();
    }

    public Weather() {
        this.day = 0;
    }

    public int getTempSpread() {
        return this.maxTemp - this.minTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
        this.sanitizeValues();
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
        this.sanitizeValues();
    }

    /**
     * switches max temp and min temp if not set correctly
     */
    private void sanitizeValues() {
        if (this.maxTemp < this.minTemp) {
            int helper = this.maxTemp;
            this.maxTemp = this.minTemp;
            this.minTemp = helper;
        }
    }

    @Override
    public String toString() {
        return this.day +
                ";" +
                this.maxTemp +
                ";" +
                this.minTemp;
    }
}
