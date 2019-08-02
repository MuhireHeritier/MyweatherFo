// Author: Heritier Muhire
// Student Id: S1719021
package com.example.myweatherfo;

public class Location {
    //Member variables representing the cityName and information about the sport
    private String cityName;
    private String info;
    private final int imageResource;

    public Location(String title, int imageResource) {
        this.cityName = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    public String getCityName() {
        return cityName;
    }

    public String getInfo() {
        return info;
    }

    public int getImageResource() {
        return imageResource;
    }
}