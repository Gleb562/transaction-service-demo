package com.mbicycle.transactionservicedemo.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HashMapConverter implements AttributeConverter<Map<String, String>, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, String> customerInfo) {
        String customerInfoJson = null;
        try {
            customerInfoJson = objectMapper.writeValueAsString(customerInfo);
        } catch (Exception e) {
            log.error("JSON writing error " + e);
        }

        return customerInfoJson;
    }

    @Override
    public Map<String, String> convertToEntityAttribute(String customerInfoJSON) {
        Map<String, String> customerInfo = null;
        try {
            customerInfo = objectMapper.readValue(customerInfoJSON, new TypeReference<HashMap<String, String>>() {});
        } catch (Exception e) {
            log.error("JSON reading error " + e);
        }

        return customerInfo;
    }
}
