package dev.johnwatts.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Snow {
    @JsonProperty("1h")
    private double hourly;

    @Override
    public String toString() {
        return "Snow{" +
                "hourly=" + hourly +
                '}';
    }
}
