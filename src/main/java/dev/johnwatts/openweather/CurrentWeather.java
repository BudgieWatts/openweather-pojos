package dev.johnwatts.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

public class CurrentWeather implements WeatherForecast {
    @JsonProperty("dt")
    @JsonDeserialize(using = UtcSecondsToZonedDateTimeDeserializer.class)
    private ZonedDateTime dateTime;
    private long sunrise;
    private long sunset;
    private double temp;
    @JsonProperty("feels_like")
    private double feelsLike;
    private int pressure;
    private int humidity;
    @JsonProperty("dew_point")
    private double dewPoint;
    private double uvi;
    private int clouds;
    private long visibility;
    @JsonProperty("wind_speed")
    private double windSpeed;
    @JsonProperty("wind_gust")
    private double windGust;
    @JsonProperty("wind_deg")
    private int windDirection;
    private Rain rain;
    private Snow snow;
    private List<Weather> weather;

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
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

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
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

    public long getVisibility() {
        return visibility;
    }

    public void setVisibility(long visibility) {
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

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }
    
    @Override
    public String toString() {
        return "CurrentWeather{" +
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
                ",\nrain=" + rain +
                ",\nsnow=" + snow +
                ",\nweather=" + weather +
                '}';
    }

    @Override
    public Duration getDuration() {
        return Duration.ZERO;
    }
}
