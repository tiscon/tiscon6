package com.tiscon.service;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class PostalCodeService {
    /**
     * APIを用いて郵便番号から住所等を取得するメゾット
     *
     * @param postal_code 郵便番号（ハイフンなし）、String型
     * @return response　郵便番号検索結果、Response型
     *
     * Response型のメゾット一覧
     *  ・getPrefecture - 都道府県を取得、String型
     *  ・getCity -  市、区などを取得、String型
     *  ・getLatitude -  緯度を取得、float型
     *  ・getLongitude -  軽度を取得、float型
     *
     * このクラスの使用には、try、catchが必要です。
     * 詳細は、Testクラスをご確認ください。
     */
        public Response getResponse(String postal_code) throws IOException  {
        Response response;

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);

        URL url = new URL("http://geoapi.heartrails.com/api/json?method=searchByPostal&postal="+postal_code);
        response = mapper.readValue(url, Response.class);

        return response;
    }
}