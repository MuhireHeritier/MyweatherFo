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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Day2Fragment extends Fragment {
    private View view;
    private List data;
    Day1Fragment fragment1;
    private CityWeatherElements element;
    private WeatherDataParserHandler handler;
    private String code;

    private TextView cityName,temperature, forecastRain, windSpeed, humidity, pressure, uvRisk, chance_of_rain;
    private ImageView weatherIcon;

    final static String urlAddress = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/";
    final static String locationIdGlasgow = "2648579";



    public Day2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        DetailActivity activity = (DetailActivity) getActivity();
        code = activity.locationCode;

        System.out.println(code);

        //load data
        loadRSSParser(urlAddress,code);

        //set element 1 as day 1 object
        element = (CityWeatherElements)data.get(1);

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_day2, container, false);
        cityName = (TextView) view.findViewById(R.id.city_name1d2);
        temperature = (TextView)view.findViewById(R.id.city_temp1_valued2);
        forecastRain = view.findViewById(R.id.city_forecast1_textd2);
        windSpeed = (TextView) view.findViewById(R.id.idToday_wind_value1d2);
        humidity = (TextView)view.findViewById(R.id.idToday_humidity_valued2);
        pressure = (TextView) view.findViewById(R.id.idToday_pressure_value1d2);
        uvRisk = view.findViewById(R.id.idToday_uvRisk_value1d2);
        chance_of_rain = view.findViewById(R.id.idToday_rain_value1d2);
        weatherIcon = (ImageView)view.findViewById(R.id.weather_icon1d2);

        forecastRain.setText(element.getForecast());
        cityName.setText(element.getCityName());
        temperature.setText(element.getTemperature());
        windSpeed.setText(element.getWindSpeed());

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_day2, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_call) {
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
