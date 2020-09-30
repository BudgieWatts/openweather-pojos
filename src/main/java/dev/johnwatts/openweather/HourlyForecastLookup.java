package dev.johnwatts.openweather;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class HourlyForecastLookup {
    private Map<LocalDate, Map<LocalTime, HourlyWeatherForecast>> lookup;

    public HourlyForecastLookup(List<HourlyWeatherForecast> forecasts) {
        this.lookup = new HashMap<>();
        forecasts.stream().forEach(hourlyWeatherForecast -> {
            LocalDate localDate = hourlyWeatherForecast.getDateTime().toLocalDate();
            if(!lookup.containsKey(localDate)){
                lookup.put(localDate, new HashMap<>());
            }
            lookup.get(localDate).put(
                    hourlyWeatherForecast.getDateTime().toLocalTime(),
                    hourlyWeatherForecast);
        });
    }

    public Optional<HourlyWeatherForecast> getHourlyWeatherForecast(LocalDateTime dateTime) {
        System.out.println("Getting hourly weather for " + dateTime);
        if(!lookup.containsKey(dateTime.toLocalDate())) {
            return Optional.empty();
        }
        Set<LocalTime> keys = lookup.get(dateTime.toLocalDate()).keySet();

        List<LocalTime> times = new ArrayList<>(keys);
        Collections.sort(times);

        LocalTime time = dateTime.toLocalTime();

        final int FIRST= 0;
        final int LAST = times.size() - 1;

        if( times.get(FIRST).isAfter(time) ) {
            return Optional.empty();
        }
        if (times.get(LAST).isBefore(time) && !times.get(LAST).equals(LocalTime.of(23,0))) {
            return Optional.empty();
        }

        for(int i = 0; i < LAST; i++) {
            LocalTime FROM = times.get(i);
            LocalTime TO = times.get(i+1);
            if( (time.equals(FROM) || time.isAfter(FROM)) && time.isBefore(TO)) {
                System.out.println("Found " + lookup.get(dateTime.toLocalDate()).get(FROM).getDateTime() + " " + lookup.get(dateTime.toLocalDate()).get(FROM).getWindDirection());
                return Optional.of(lookup.get(dateTime.toLocalDate()).get(FROM));
            }
        }

        if( (time.equals(times.get(LAST)) || time.isAfter(times.get(LAST))) && time.isBefore(LocalTime.MAX)) {
            System.out.println("Found " + lookup.get(dateTime.toLocalDate()).get(times.get(LAST)).getDateTime() + " " + lookup.get(dateTime.toLocalDate()).get(times.get(LAST)).getWindDirection());
            return Optional.of(lookup.get(dateTime.toLocalDate()).get(times.get(LAST)));
        }
        return Optional.empty();
    }

}
