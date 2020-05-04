package com.example.weather;

public class Weather {
    private int img;
    private String description;

    public Weather(int img, String description) {
        this.img = img;
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public String getDescription() {
        return description;
    }
}
