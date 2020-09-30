Some basic POJO stuff to get you started with the https://openweathermap.org/api

This isn't a complete implementation but concentrates on the "OneCall" response.

Be careful around the `EpochSecondsToLocalDateConvertor` and the abstract class it's used in.  It's basically an untidy relic from an initial implementation.

If you want to deal with MinutelyWeather you should probably alter it to bring it in line with the other classes which use `UtcSecondsToZonedDateTimeDeserializer`.

The `HourlyForecastLookup` gives you an `Optional<HourlyWeatherForecast>` if you pass in a `LocalDateTime`.  If that time isn't in the returned forecast you'll get an `Optional.empty`

`WeatherClient` will give you a `OneCallResponse` if you pass in latitude and longitude.  You'll need to get and supply your api key from [OpenWeatherMap]('https://openweathermap.org/guide').