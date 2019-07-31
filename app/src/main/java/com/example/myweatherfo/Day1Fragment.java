/**
 * created by Heritier Muhire
 * Student Id: S1719021
 */
package com.example.myweatherfo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Day1Fragment extends Fragment {

    final static String urlAddress = "https://weather-broker-cdn.api.bbci.co.uk/en/forecastRain/rss/3day/";
    final static String locationIdGlasgow = "2648579";
    final static String locationIdLondon = "2643743";
    final static String locationIdNewYork = "5128581";
    final static String locationIdOman = "287286";
    final static String locationIdMauritius = "934154";
    final static String locationIdBangladesh = "1185241";
    final static String locationIdKigali = "202061";

    private TextView cityName,temperature, weatherIcon, forecastRain, wind, humidity, pressure, uvRisk, chance_of_rain;

    private View view;
    private List data;
    private CityWeatherElements element;
    private WeatherDataParserHandler handler;

    public Day1Fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        //load data
        loadRSSParser(urlAddress,locationIdGlasgow);

        //set element 1 as day 1 object
        element = (CityWeatherElements)data.get(0);

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_day1, container, false);
        cityName = (TextView) view.findViewById(R.id.city_name1);
        temperature = (TextView)view.findViewById(R.id.city_temp1_value);
        forecastRain = view.findViewById(R.id.city_forecast1_text);
        wind = (TextView) view.findViewById(R.id.idToday_wind_value1);
        humidity = (TextView)view.findViewById(R.id.idToday_humidity_value);
        pressure = (TextView) view.findViewById(R.id.idToday_pressure_value1);
        uvRisk = view.findViewById(R.id.idToday_uvRisk_value1);
        chance_of_rain = view.findViewById(R.id.idToday_rain_value1);
        weatherIcon = view.findViewById(R.id.weather_icon1);

        cityName.setText(element.getCityName());
        forecastRain.setText(element.getForecast());
        weatherIcon.setText(element.getWeatherImage());

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_day1, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_chat) {
            Toast.makeText(getActivity(), "Clicked on " + item.getTitle(), Toast.LENGTH_SHORT)
                    .show();
        }
        return true;
    }

    public void loadRSSParser(String url, String code){

        handler = new WeatherDataParserHandler(url+code);
        handler.connector();
        while (handler.complete);
        data = handler.getCityWeatherElementsList();
    }
}
