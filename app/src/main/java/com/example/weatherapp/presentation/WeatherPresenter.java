package com.example.weatherapp.presentation;

import com.example.weatherapp.data.OpenWeatherService;
import com.example.weatherapp.data.WeatherData;
import com.example.weatherapp.domain.WeatherService;
import com.example.weatherapp.domain.WeatherView;

/**
 * @author tamarlehmann on 23/11/2017.
 */

public class WeatherPresenter implements WeatherService.ResponseListener {

    private OpenWeatherService weatherService;
    private WeatherView weatherView;



    public WeatherPresenter(OpenWeatherService weatherService, WeatherView weatherView) {
        this.weatherService = weatherService;
        this.weatherView = weatherView;
    }

    public void getWeather() {
        weatherService.callApi(this);
    }

    @Override
    public void onSuccess(WeatherData data) {
        weatherView.render(data.getName());
    }

    @Override
    public void onFailure() {
        weatherView.notifyFailure();
    }
}
