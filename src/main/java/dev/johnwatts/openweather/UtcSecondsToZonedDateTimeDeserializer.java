package dev.johnwatts.openweather;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class UtcSecondsToZonedDateTimeDeserializer extends StdDeserializer<ZonedDateTime> {
    private final Logger logger = LoggerFactory.getLogger(UtcSecondsToZonedDateTimeDeserializer.class);

    public UtcSecondsToZonedDateTimeDeserializer() {
        this(null);
    }

    @Override
    public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        Instant instant = Instant.ofEpochSecond(node.longValue());
        return ZonedDateTime.ofInstant(instant, ZoneId.of("UTC"));
    }
    protected UtcSecondsToZonedDateTimeDeserializer(Class<?> valueType) {
        super(valueType);
    }
}
