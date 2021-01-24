package com.tiscon.service;

public class Response {
    public LocationList response;

    public String getPrefecture(){
        return this.response.location.get(0).prefecture;
    }
    public String getCity(){
        return this.response.location.get(0).city;
    }
    public String getTown(){
        return this.response.location.get(0).town;
    }
    public Float getLatitude(){
        return this.response.location.get(0).y;
    }
    public Float getLongitude(){
        return this.response.location.get(0).x;
    }
}
