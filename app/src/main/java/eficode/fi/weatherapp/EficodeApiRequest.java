package eficode.fi.weatherapp;


import android.util.Log;

import eficode.fi.weatherapp.data.GetForecast;
import eficode.fi.weatherapp.interfaces.IResponseHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EficodeApiRequest {
    //Getting the response from Efficode Api and placing the result in callback interface
    public static void getForecast(final double latitude, final double longitude, final IResponseHelper iResponseHelper) {
        WeatherApplication.getInstance().getApiWeatherService().getForecast(latitude, longitude).enqueue(new Callback<GetForecast>() {
            @Override
            public void onResponse(Call<GetForecast> call, Response<GetForecast> response) {
                if (response.isSuccessful()) {
                    iResponseHelper.getData(response.body());
                }
            }

            @Override
            public void onFailure(Call<GetForecast> call, Throwable t) {
                Log.d("ERROR", "Failed Get Request " + t.getMessage());
            }
        });
    }
}
