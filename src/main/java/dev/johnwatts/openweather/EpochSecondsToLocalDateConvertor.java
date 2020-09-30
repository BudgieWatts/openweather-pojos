package dev.johnwatts.openweather;

import java.time.*;

public class EpochSecondsToLocalDateConvertor {
    private ZoneId zoneId;
    private ZoneOffset zoneOffset;

    public EpochSecondsToLocalDateConvertor(String zoneId,
                                            int zoneOffsetSeconds) {
        this.zoneId = ZoneId.of(zoneId);
        this.zoneOffset = ZoneOffset.ofTotalSeconds(zoneOffsetSeconds);
    }

    public LocalDateTime getLocalDateTime(long epochSeconds) {
        return LocalDateTime.ofEpochSecond(epochSeconds, 0, zoneOffset);
    }

    public LocalDate getLocalDate(long epochSeconds) {
        return getLocalDateTime(epochSeconds).toLocalDate();
    }

    public LocalTime getLocalTime(long epochSeconds) {
        return getLocalDateTime(epochSeconds).toLocalTime();
    }
}
