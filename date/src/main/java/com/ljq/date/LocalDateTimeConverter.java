//package com.ljq.date;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//
///**
// * @author : lijq
// * @date : 2020/3/8 13:52
// */
//@Component
//public class LocalDateTimeConverter extends JsonSerializer<LocalDateTime> {
//    @Override
//    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//        jsonGenerator.writeNumber(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
//    }
//}
