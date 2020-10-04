package dev.johnwatts.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

public class DailyWeatherForecast implements WeatherForecast, ForecastDuration {
    @JsonProperty("dt")
    @JsonDeserialize(using = UtcSecondsToZonedDateTimeDeserializer.class)
    private ZonedDateTime dateTime;

    @JsonDeserialize(using = UtcSecondsToZonedDateTimeDeserializer.class)
    private ZonedDateTime sunrise;

    @JsonDeserialize(using = UtcSecondsToZonedDateTimeDeserializer.class)
    private ZonedDateTime sunset;

    private Temperature temp;

    @JsonProperty("feels_like")
    private FeelsLike feelsLike;

    private long pressure;
    private int humidity;

    @JsonProperty("dew_point")
    private double dewPoint;

    private double uvi;
    private int clouds;
    private int visibility;

    @JsonProperty("wind_speed")
    private double windSpeed;

    @JsonProperty("wind_gust")
    private double windGust;

    @JsonProperty("wind_deg")
    private int windDirection;

    private double pop;
    private double rain;
    private double snow;
    private List<Weather> weather;

    @Override
    public Duration getDuration() {
        return Duration.ofHours(24);
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ZonedDateTime getSunrise() {
        return sunrise;
    }

    public void setSunrise(ZonedDateTime sunrise) {
        this.sunrise = sunrise;
    }

    public ZonedDateTime getSunset() {
        return sunset;
    }

    public void setSunset(ZonedDateTime sunset) {
        this.sunset = sunset;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public FeelsLike getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(FeelsLike feelsLike) {
        this.feelsLike = feelsLike;
    }

    public long getPressure() {
        return pressure;
    }

    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public double getUvi() {
        return uvi;
    }

    public void setUvi(double uvi) {
        this.uvi = uvi;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindGust() {
        return windGust;
    }

    public void setWindGust(double windGust) {
        this.windGust = windGust;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public double getPop() {
        return pop;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public double getSnow() {
        return snow;
    }

    public void setSnow(double snow) {
        this.snow = snow;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "DailyWeatherForecast{" +
                "dt=" + getDateTime() +
                ",\nsunrise=" + sunrise +
                ",\nsunset=" + sunset +
                ",\ntemp=" + temp +
                ",\nfeels_like=" + feelsLike +
                ",\npressure=" + pressure +
                ",\nhumidity=" + humidity +
                ",\ndew_point=" + dewPoint +
                ",\nuvi=" + uvi +
                ",\nclouds=" + clouds +
                ",\nvisibility=" + visibility +
                ",\nwind_speed=" + windSpeed +
                ",\nwind_gust=" + windGust +
                ",\nwind_deg=" + windDirection +
                ",\npop=" + pop +
                ",\nrain=" + rain +
                ",\nsnow=" + snow +
                ",\nweather=" + weather +
                '}';
    }
}
