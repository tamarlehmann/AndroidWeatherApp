package com.example.weatherapp.domain;

/**
 * @author tamarlehmann on 23/11/2017.
 */

public interface WeatherView {

    void render(String location);

    void notifyFailure();

}
