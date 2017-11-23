package com.example.weatherapp.data;

import com.example.weatherapp.domain.WeatherApi;
import com.example.weatherapp.domain.WeatherService;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author tamarlehmann on 23/11/2017.
 */

public class OpenWeatherService implements WeatherService {

    private final String baseUrl = "https://api.openweathermap.org";

    private Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create());

    private OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private Retrofit retrofit = builder
            .client(httpClient.build())
            .build();

    @Override
    public void callApi(final ResponseListener listener) {
        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        Call<WeatherData> call = weatherApi.getData();

        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                WeatherData data = response.body();
                listener.onSuccess(data);
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                listener.onFailure();
            }
        });
    }
}
