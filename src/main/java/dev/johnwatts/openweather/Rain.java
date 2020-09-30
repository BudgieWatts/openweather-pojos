package dev.johnwatts.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
    @JsonProperty("1h")
    private double hourly;

    @Override
    public String toString() {
        return "Rain{" +
                "hourly=" + hourly +
                '}';
    }
}
