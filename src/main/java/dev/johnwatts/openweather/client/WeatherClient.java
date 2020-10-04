package dev.johnwatts.openweather.client;

import dev.johnwatts.openweather.OneCallResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class WeatherClient {

    private final Client client;
    private static final String apiKey = "GET_YOUR_OWN";
    private static final String urlTemplate = "https://api.openweathermap.org/data/2.5/onecall?lat=%f&lon=%f&appid=%s&units=metric";

    public WeatherClient() {
        this.client = ClientBuilder.newClient();
    }

    public OneCallResponse getWeather(double latitude, double longitude) {

        WebTarget webTarget = this.client.target(String.format(urlTemplate, latitude, longitude, apiKey));
        return webTarget.request().get(OneCallResponse.class);
    }
}
