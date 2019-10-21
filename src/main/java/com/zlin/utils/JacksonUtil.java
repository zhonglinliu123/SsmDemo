package com.zlin.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zlin.pojo.User;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class JacksonUtil {
    private ObjectMapper objectMapper = new ObjectMapper();

    public String bean2Json(Object obj){
        try {
            return objectMapper.writeValueAsString(obj);
        }catch (JsonProcessingException e){
            e.printStackTrace();
            return null;
        }
    }

    public User json2Bean(String jsonStr){
        try {
            return objectMapper.readValue(jsonStr, User.class);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}

