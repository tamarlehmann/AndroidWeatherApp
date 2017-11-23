package com.example.weatherapp.domain;

import com.example.weatherapp.data.WeatherData;

/**
 * @author tamarlehmann on 23/11/2017.
 */

public interface WeatherService {

    void callApi(ResponseListener listener);

    interface ResponseListener {

        void onSuccess(WeatherData data);

        void onFailure();

    }

}
