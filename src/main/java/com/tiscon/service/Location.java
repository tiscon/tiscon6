package com.tiscon.service;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.util.List;

public class Location {
    public String prefecture;
    public String city;
    public String city_kana;
    public String town;
    public String town_kana;
    public float x;
    public float y;
    public String postal;
}

