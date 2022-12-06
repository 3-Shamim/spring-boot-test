package com.learningstuff.springboottest.jacksons;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ২৫/১১/২২
 * Time: ১০:৫০ PM
 * Email: mdshamim723@gmail.com
 */

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    private final DateTimeFormatter dateTimeFormatter;

    public LocalDateDeserializer() {
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("[MM-dd-yyyy][dd/MM/yyyy]");
    }

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctx) {

        try {
//            ZonedDateTime parse = ZonedDateTime.parse(p.getValueAsString(), dateTimeFormatter).withZoneSameInstant(ZoneId.systemDefault());
//            System.out.println(parse);
//            return LocalDate.from(parse);
            return LocalDate.parse(p.getValueAsString(), dateTimeFormatter);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Invalid date format. ex: MM-dd-yyyy | dd/MM/yyyy. %s", e.getMessage()));
        }
    }
}