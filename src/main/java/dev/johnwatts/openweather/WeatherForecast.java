package dev.johnwatts.openweather;

public interface WeatherForecast extends DateTime, ForecastDuration {


    double getWindSpeed();
    double getWindGust();
    int getWindDirection();
}
