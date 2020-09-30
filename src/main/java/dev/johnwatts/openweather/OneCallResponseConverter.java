package dev.johnwatts.openweather;

import com.fasterxml.jackson.databind.util.StdConverter;

public class OneCallResponseConverter extends StdConverter<OneCallResponse, OneCallResponse> {
    @Override
    public OneCallResponse convert(OneCallResponse oneCallResponse) {

        oneCallResponse.setHourlyForecastLookup(new HourlyForecastLookup(oneCallResponse.getHourly()));
        return oneCallResponse;
    }
}
