package com.tiscon.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class PostalCodeService {
    Response response;

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException  {

        List<Sa> response_list = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);

        URL url = new URL("http://geoapi.heartrails.com/api/json?method=searchByPostal&postal=3490115");

        PostalCodeService hoge = mapper.readValue(url, PostalCodeService.class);
        // System.out.println(mapper.readValue(url, PostalCodeService.class));
    }

}