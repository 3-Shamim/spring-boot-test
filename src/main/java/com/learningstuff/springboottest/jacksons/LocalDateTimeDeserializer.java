package com.learningstuff.springboottest.jacksons;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ২৫/১১/২২
 * Time: ১০:৫০ PM
 * Email: mdshamim723@gmail.com
 */

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private final DateTimeFormatter dateTimeFormatter;

    public LocalDateTimeDeserializer() {
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("[MM-dd-yyyy HH:mm:ss][dd/MM/yyyy HH:mm:ss][MM-dd-yyyy]");
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctx) {

        try {

            String value = p.getValueAsString();

            try {
                long millis = Long.parseLong(value);

                if (millis < 1) {
                    return null;
                }

                return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), TimeZone.getDefault().toZoneId());
            } catch (Exception e) {
                String[] split = value.split(" ");

                if (split.length == 1) {
                    value = String.format("%s %s", value, "00:00:00");
                }

                return LocalDateTime.parse(value, dateTimeFormatter);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Invalid date format. ex: MM-dd-yyyy | MM-dd-yyyy HH:mm:ss | dd/MM/yyyy HH:mm:ss | Millis. %s", e.getMessage()));
        }
    }
}