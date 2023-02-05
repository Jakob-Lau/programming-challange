package de.bcxp.challenge.weather;

import java.util.Comparator;

public class WeatherTempSpreadComparator implements Comparator<Weather> {

    @Override
    public int compare(Weather weather1, Weather weather2) {
        return Integer.compare(weather1.getTempSpread(), weather2.getTempSpread());
    }
}
