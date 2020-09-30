package dev.johnwatts.openweather;

import java.time.ZonedDateTime;
import java.util.Objects;

public class HourlyPeriod implements Comparable<HourlyPeriod> {
    ZonedDateTime from;
    ZonedDateTime to;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HourlyPeriod that = (HourlyPeriod) o;
        return from.equals(that.from) &&
                to.equals(that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    public HourlyPeriod(ZonedDateTime from) {
        this.from = from;
        this.to = from.plusHours(1);
    }

    public ZonedDateTime getFrom() {
        return from;
    }

    public ZonedDateTime getTo() {
        return to;
    }

    @Override
    public int compareTo(HourlyPeriod hourlyPeriod) {
        return this.to.compareTo(hourlyPeriod.to);
    }
}
