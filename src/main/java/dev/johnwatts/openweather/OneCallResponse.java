package dev.johnwatts.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(converter = OneCallResponseConverter.class)
public class OneCallResponse {
    private double lat;
    private double lon;
    private String timezone;
    private int timezoneOffset;
    private CurrentWeather current;
    private List<DailyWeatherForecast> daily;

    private List<HourlyWeatherForecast> hourly;
    HourlyForecastLookup hourlyForecastLookup;

    private List<MinutelyWeather> minutely;

    private List<Alert> alerts;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("getTimezone_offset")
    public int getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(int timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public CurrentWeather getCurrent() {
        return current;
    }

    public void setCurrent(CurrentWeather current) {
        this.current = current;
    }

    public List<DailyWeatherForecast> getDaily() {
        return daily;
    }

    public void setDaily(List<DailyWeatherForecast> daily) {
        this.daily = daily;
    }

    public List<HourlyWeatherForecast> getHourly() {
        return hourly;
    }

    public void setHourly(List<HourlyWeatherForecast> hourly) {
        this.hourly = hourly;
    }

    public List<MinutelyWeather> getMinutely() {
        return minutely;
    }

    public void setMinutely(List<MinutelyWeather> minutely) {
        this.minutely = minutely;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    protected void setHourlyForecastLookup(HourlyForecastLookup hourlyForecastLookup) {
        this.hourlyForecastLookup = hourlyForecastLookup;
    }

    public HourlyForecastLookup getHourlyForecastLookup() {
        return this.hourlyForecastLookup;
    }


    @Override
    public String toString() {
        return "OneCallResponse{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", timezone='" + timezone + '\'' +
                ", timezone_offset=" + timezoneOffset +
                ", current=" + current +
                ", daily=" + daily +
                ", hourly=" + hourly +
                ", alerts=" + alerts +
                '}';
    }
}
