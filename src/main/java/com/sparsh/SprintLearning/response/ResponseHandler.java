package com.sparsh.SprintLearning.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus httpStatus, Object response){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status",httpStatus.value());
        map.put("responseBody", response);


        return new ResponseEntity<Object>(map,httpStatus);
    }
}
