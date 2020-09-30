package dev.johnwatts.openweather;

import dev.johnwatts.openweather.UtcSecondsToZonedDateTimeDeserializer;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class WeatherModel {
    private OneCallResponse fullResponse;
    private Map<HourlyPeriod, WeatherForecast> hourlyForecastLookup;

    public WeatherModel(OneCallResponse fullResponse) {
        this.fullResponse = fullResponse;
        hourlyForecastLookup = new ConcurrentHashMap<>();

        ZonedDateTime lastHourlyForecast = fullResponse.getHourly().get(fullResponse.getHourly().size() - 1).getDateTime();
        fullResponse.getDaily().forEach(
                dailyWeatherForecast -> {
                    IntStream.range(0, 24).forEach(
                            hour -> {
                                HourlyPeriod hourlyPeriod = new HourlyPeriod(dailyWeatherForecast.getDateTime().with(LocalTime.of(hour, 0)));
                                if (hourlyPeriod.getFrom().isAfter(lastHourlyForecast)) {
                                    hourlyForecastLookup.put(
                                            hourlyPeriod,
                                            dailyWeatherForecast);
                                }
                            }
                    );
                }
        );

        // find the first hourly forecast and remove any existing hourly forecasts from the map

        fullResponse.getHourly().stream().forEach(
                hourlyWeatherForecast -> {
                    hourlyForecastLookup.put(
                            new HourlyPeriod(hourlyWeatherForecast.getDateTime()),
                            hourlyWeatherForecast);
                }
        );
    }

    public Optional<WeatherForecast> getForecastFor(ZonedDateTime time) {
        HourlyPeriod period = new HourlyPeriod(time.truncatedTo(ChronoUnit.HOURS));
        return Optional.ofNullable(hourlyForecastLookup.get(period));
    }

    public Optional<ZonedDateTime> getSunrise(ZonedDateTime date) {
        Optional<DailyWeatherForecast> forecast = this.fullResponse.getDaily()
                .stream().filter(d -> d.getDateTime().toLocalDate().equals(date.toLocalDate()))
                .findFirst();
        if( forecast.isPresent() ) {
            return Optional.of(forecast.get().getSunrise());
        } else {
            return Optional.empty();
        }
    }

    public Optional<ZonedDateTime> getSunset(ZonedDateTime date) {
        Optional<DailyWeatherForecast> forecast = this.fullResponse.getDaily()
                .stream().filter(d -> d.getDateTime().toLocalDate().equals(date.toLocalDate()))
                .findFirst();
        if( forecast.isPresent() ) {
            return Optional.of(forecast.get().getSunset());
        } else {
            return Optional.empty();
        }
    }
}
