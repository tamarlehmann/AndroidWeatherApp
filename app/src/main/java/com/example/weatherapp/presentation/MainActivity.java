package com.example.weatherapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.weatherapp.R;
import com.example.weatherapp.data.OpenWeatherService;
import com.example.weatherapp.domain.WeatherView;

/**
 * @author tamarlehmann on 23/11/2017.
 */

public class MainActivity extends AppCompatActivity implements WeatherView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OpenWeatherService weatherService = new OpenWeatherService();
        WeatherPresenter weatherPresenter = new WeatherPresenter(weatherService, this);
        weatherPresenter.getWeather();
    }

    public void render(String location) {
        Toast.makeText(this, "Location: " + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public void notifyFailure() {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
    }

}



