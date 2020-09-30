package dev.johnwatts.openweather;

public class MinutelyWeather extends ReturnsDateTime {
    private long dt;
    private double precipitation;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    @Override
    public String toString() {
        return "MinutelyWeather{" +
                "dt=" + getDateTime(dt) +
                ",\nprecipitation=" + precipitation +
                '}';
    }
}
