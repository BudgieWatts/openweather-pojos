package dev.johnwatts.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.ZonedDateTime;

public class Alert {
    @JsonProperty("sender_name")
    private String senderName;
    private String event;

    @JsonDeserialize(using = UtcSecondsToZonedDateTimeDeserializer.class)
    private ZonedDateTime start;

    @JsonDeserialize(using = UtcSecondsToZonedDateTimeDeserializer.class)
    private ZonedDateTime end;

    private String description;

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public ZonedDateTime getStart() {
        return start;
    }

    public void setStart(ZonedDateTime start) {
        this.start = start;
    }

    public ZonedDateTime getEnd() {
        return end;
    }

    public void setEnd(ZonedDateTime end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "sender_name='" + senderName + '\'' +
                ", event='" + event + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", description='" + description + '\'' +
                '}';
    }
}
