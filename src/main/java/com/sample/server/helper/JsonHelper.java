package com.sample.server.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonHelper {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void merge(Object existing, Object input) throws IOException {
        final ObjectReader objectReader = objectMapper.readerForUpdating(existing);
        objectReader.readValue(objectMapper.writeValueAsBytes(input));
    }
}