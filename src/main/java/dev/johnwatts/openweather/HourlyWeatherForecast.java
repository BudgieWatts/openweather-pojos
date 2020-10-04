package dev.johnwatts.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

public class HourlyWeatherForecast implements WeatherForecast, ForecastDuration {
    @JsonProperty("dt")
    @JsonDeserialize(using = UtcSecondsToZonedDateTimeDeserializer.class)
    private ZonedDateTime dateTime;
    private double temp;
    @JsonProperty("feels_like")
    private double feelsLike;
    private long pressure;
    private int humidity;
    @JsonProperty("dew_point")
    private double dewPoint;
    private int clouds;
    private int visibility;
    @JsonProperty("wind_speed")
    private double windSpeed;
    @JsonProperty("wind_gust")
    private double windGust;
    @JsonProperty("wind_deg")
    private int windDirection;
    private double pop;
    private Rain rain;
    private Snow snow;
    private List<Weather> weather;

    @Override
    public Duration getDuration() {
        return Duration.ofHours(1);
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
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

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
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
        return "HourlyWeatherForecast{" +
                "dt=" + getDateTime() +
                ",\ntemp=" + temp +
                ",\nfeels_like=" + feelsLike +
                ",\npressure=" + pressure +
                ",\nhumidity=" + humidity +
                ",\ndew_point=" + dewPoint +
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
