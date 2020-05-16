package com.example.weather.list_elements;

import android.content.res.Resources;
import android.content.res.TypedArray;

import com.example.weather.R;

import java.util.ArrayList;

public class WeatherSource {
    private ArrayList<Weather> listWeather;
    private Resources resources;

    public WeatherSource(Resources resources) {
        this.listWeather = new ArrayList<>();
        this.resources = resources; //чтобы вытащить данные из ресурсов
    }

    public WeatherSource build(){
        String[] descriptions = resources.getStringArray(R.array.items);
        int[] pictures = getImageArray();
        for (int i = 0; i < pictures.length; i++) {
            listWeather.add(new Weather(pictures[i], descriptions[i]));
        }
        return this;
    }
    private int[] getImageArray(){
        TypedArray picters = resources.obtainTypedArray(R.array.pictures);
        int length = picters.length();
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[i] = picters.getResourceId(i, 0);
        }
        return answer;
    }

    public ArrayList<Weather> getListWeather() {
        return listWeather;
    }
}
