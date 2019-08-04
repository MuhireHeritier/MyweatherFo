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

import com.example.myweatherfo.controller.WeatherDataParserHandler;
import com.example.myweatherfo.model.CityWeatherElements;

import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Day1Fragment extends Fragment {

    final static String urlAddress = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/";
    MenuActivity detailActivity = new MenuActivity();
    String code;

    HashMap <String, String> hp = new HashMap<>();

    private TextView cityName,temperature,minTemp,maxTemp, forecastRain, windSpeed, windDirection, humidity, visibility, sunrise,sunset, pressure, uvRisk, pubDate;
    private View view;
    private List data;
    private CityWeatherElements element;
    private WeatherDataParserHandler handler;

    private ImageView weatherIcon;

    public Day1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        MenuActivity activity = (MenuActivity) getActivity();
        code = activity.locationCode;

        System.out.println(code);

        //load data
        loadRSSParser(urlAddress,code);

        //set element 1 as day 1 object
        element = (CityWeatherElements)data.get(0);

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_day1, container, false);
        cityName = (TextView) view.findViewById(R.id.city_name1);
        temperature = (TextView)view.findViewById(R.id.city_temp1_value);
        forecastRain = view.findViewById(R.id.city_forecast1_text);
        windSpeed = (TextView) view.findViewById(R.id.windSpeed_value1);
        windDirection = view.findViewById(R.id.wind_dir1_value);
        visibility = view.findViewById(R.id.idToday_visibility_value1);

        sunrise = view.findViewById(R.id.sunrise_value1);
        sunset = view.findViewById(R.id.sunset_value1);
        humidity = (TextView)view.findViewById(R.id.humidity_value1);
        pressure = (TextView) view.findViewById(R.id.pressure_value1);
        uvRisk = view.findViewById(R.id.uvRisk_value1);
        pubDate = view.findViewById(R.id.day_date1);

        weatherIcon = view.findViewById(R.id.weather_icon1);
        minTemp = view.findViewById(R.id.min_temp_valued1);
        maxTemp = view.findViewById(R.id.max_temp_valued1);

        cityName.setText(element.getCityName());
        forecastRain.setText(element.getForecast());
        temperature.setText(element.getTemperature());
        windSpeed.setText(element.getWindSpeed());
        windDirection.setText(element.getWindDirection());
        visibility.setText(element.getVisibility());

        pressure.setText(element.getPressure());
        humidity.setText(element.getHumidity());
        uvRisk.setText(element.getUvRisk());
        sunrise.setText(element.getSunrise());
        sunset.setText(element.getSunset());
        pubDate.setText(element.getTodayDate());

        weatherIcon.setImageResource(element.getWeatherIcon());
        minTemp.setText(element.getMinTemp());
        maxTemp.setText(element.getMaxTemp());

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
