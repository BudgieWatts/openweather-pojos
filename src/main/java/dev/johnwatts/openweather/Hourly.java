package dev.johnwatts.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hourly {
    private double hourly;

    @JsonProperty("1h")
    public double getHourly() {
        return hourly;
    }

    @JsonProperty("1h")
    public void setHourly(double hourly) {
        this.hourly = hourly;
    }

    @Override
    public String toString() {
        return "Hourly{" +
                "hourly=" + hourly +
                '}';
    }
}
