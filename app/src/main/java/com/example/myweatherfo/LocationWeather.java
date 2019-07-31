// Author: Heritier Muhire
// Student Id: S1719021
package com.example.myweatherfo;

public class LocationWeather {
    private String cityName;
    private int cityTemperature;
    private int cityImage;

    public LocationWeather(String cityName, int cityImage, int cityTemperature) {
        this.cityName = cityName;
        this.cityImage = cityImage;
        this.cityTemperature = cityTemperature;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityImage() {
        return cityImage;
    }

    public void setCityImage(int cityImage) {
        this.cityImage = cityImage;
    }

    public int getCityTemperature() {
        return cityTemperature;
    }


    public void setCityTemperature(int cityTemperature) {
        this.cityTemperature = cityTemperature;
    }

}
