package dev.johnwatts.openweather;

public interface WeatherForecast extends DateTime, ForecastDuration, WindDetails {

    // Expand this to cover the common features of HourlyForecast and DailyForecast.

    /* Currently I'm only interested in the wind so in the interests of the Interface Segregation Principle those
     * details are encapsulated in the WindDetails interface. On the face of it, this seems like interfacephila but it
     * enables users of this code to signal their intent and also, to deal with less stuff.
     *
     * Consider something that needs wind details - we can have:
     *
     *   WeatherForecast forecast = new WeatherModel(client.getWeather(lat, long)).getForecastFor(aZonedDateTime);
     *   Foo processWindDetails(WeatherForecast forecast);
     *
     * or:
     *
     *   WeatherForecast forecast = new WeatherModel(client.getWeather(lat, long)).getForecastFor(aZonedDateTime);
     *   Foo processWindDetails(WindDetails forecast);
     *
     * and we can concentrate on the things we're interested in within that method and not worry about a whole bunch of
     * measures we don't care about.
     *
     */
}
