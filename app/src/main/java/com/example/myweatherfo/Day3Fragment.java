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
public class Day3Fragment extends Fragment {

    private TextView cityName,temperature, forecastRain, windSpeed,windDirection, visibility, humidity,sunset, sunrise, pressure, uvRisk;
    private ImageView weatherIcon;

    final static String urlAddress = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/";

    private View view;
    private List data;
    private CityWeatherElements element;
    private WeatherDataParserHandler handler;
    private String code;



    public Day3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_day3, container, false);
        DetailActivity activity = (DetailActivity) getActivity();
        code = activity.locationCode;

        System.out.println(code);

        //load data
        loadRSSParser(urlAddress,code);

        //set element 1 as day 1 object
        element = (CityWeatherElements)data.get(2);

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_day3, container, false);
        cityName = (TextView) view.findViewById(R.id.city_name1d3);
        temperature = (TextView)view.findViewById(R.id.city_temp1_valued3);
        forecastRain = view.findViewById(R.id.city_forecast1_textd3);
        windSpeed = (TextView) view.findViewById(R.id.wind_value1d3);
        windDirection = view.findViewById(R.id.wind_value1d3);
        visibility = view.findViewById(R.id.visibility_value1d3);
        sunrise = view.findViewById(R.id.sunrise_value1d3);
        sunset = view.findViewById(R.id.sunset_value1d3);
        humidity = (TextView)view.findViewById(R.id.humidity_valued3);
        pressure = (TextView) view.findViewById(R.id.pressure_value1d3);
        uvRisk = view.findViewById(R.id.idToday_uvRisk_value1d3);
        weatherIcon = (ImageView)view.findViewById(R.id.weather_icon1d3);

        cityName.setText(element.getCityName());
        forecastRain.setText(element.getForecast());
        temperature.setText(element.getTemperature());
        windSpeed.setText(element.getWindSpeed());
        windDirection.setText(element.getWindDirection());
        visibility.setText(element.getVisibility());

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_day3, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        {
            if (item.getItemId() == R.id.action_status) {
                Toast.makeText(getActivity(), "Clicked on " + item.getTitle(), Toast.LENGTH_SHORT)
                        .show();
            }
            return true;
        }
    }

    public void loadRSSParser(String url, String code){

        handler = new WeatherDataParserHandler(url+code);
        handler.connector();
        while (handler.complete);
        data = handler.getCityWeatherElementsList();
    }
}
