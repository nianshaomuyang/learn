package com.tangyi.learn.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonChange {

    /**
     * json字符串转换为map
     */
    public static <T> Map<String, Object> json2map(String jsonString) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.readValue(jsonString, Map.class);
    }

}

