package com.example.weatherapp.domain;

import com.example.weatherapp.data.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author tamarlehmann on 23/11/2017.
 */

public interface WeatherApi {

    @GET("/data/2.5/weather?q=London,uk&APPID=9c01ca583b73254a087834fc09e38d23")
    Call<WeatherData> getData();

}
