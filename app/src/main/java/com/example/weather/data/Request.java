package com.example.weather.data;

import android.os.Build;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.weather.BuildConfig;
import com.example.weather.MainActivity;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

public class Request {






    private static final String TAG = "WEATHER_MY";

    private String city;
    private String temperature;
    private String pressure;
    private String humidity;
    private String windSpeed;


        public void init() {
            try {

                final URL uri = new URL(request(MainActivity.getPosition()) + BuildConfig.WEATHER_API_KEY);
                final Handler handler = new Handler();
                new Thread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void run() {
                        HttpsURLConnection urlConnection = null;
                        try {
                            urlConnection = (HttpsURLConnection) uri.openConnection();
                            urlConnection.setRequestMethod("GET");
                            urlConnection.setReadTimeout(10000);
                            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                            String result = getLines(in);
                            Gson gson = new Gson();
                            final WeatherRequest weatherRequest = gson.fromJson(result, WeatherRequest.class);
                            city = (weatherRequest.getName());
                            temperature = String.format("%.1f", weatherRequest.getMain().getTemp());
                            pressure = String.format("%d", weatherRequest.getMain().getPressure());
                            humidity = String.format("%d", weatherRequest.getMain().getHumidity());
                            windSpeed = String.format("%d", weatherRequest.getWind().getSpeed());

                        } catch (Exception e) {
                            Log.e(TAG, "Fail Connection", e);
                            e.printStackTrace();
                        }
                    }

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    private String getLines(BufferedReader in) {
                        return in.lines().collect(Collectors.joining("\n"));
                    }
                }).start();
            } catch (Exception e) {
                Log.e(TAG, "Fail URL", e);
                e.printStackTrace();
            }
        }

        public String request(int num) {
            String reqest = "";
            switch (num) {
                case 0:
                    reqest = "https://api.openweathermap.org/data/2.5/weather?lat=45.04&lon=38.97&units=metric&appid=";
                    break;
                case 1:
                    reqest = "https://api.openweathermap.org/data/2.5/weather?lat=55.75&lon=37.62&units=metric&appid=";
                    break;
                case 2:
                    reqest = "https://api.openweathermap.org/data/2.5/weather?lat=59.93&lon=30.31&units=metric&appid=";
                    break;
            }
            return reqest;
        }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
