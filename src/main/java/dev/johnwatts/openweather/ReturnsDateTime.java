package dev.johnwatts.openweather;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class ReturnsDateTime {

    private EpochSecondsToLocalDateConvertor epochSecondsToLocalDateConvertor;

    public LocalDate getDate(long epochSeconds) {
        return epochSecondsToLocalDateConvertor.getLocalDate(epochSeconds);
    }

    public LocalTime getTime(long epochSeconds) {
        return epochSecondsToLocalDateConvertor.getLocalTime(epochSeconds);
    }

    public LocalDateTime getDateTime(long epochSeconds) {
        return epochSecondsToLocalDateConvertor.getLocalDateTime(epochSeconds);
    }

    public void setDateTimeConverter(EpochSecondsToLocalDateConvertor epochSecondsToLocalDateConvertor) {
        this.epochSecondsToLocalDateConvertor = epochSecondsToLocalDateConvertor;
    }
}
