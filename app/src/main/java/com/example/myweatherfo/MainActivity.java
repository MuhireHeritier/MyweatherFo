// Names : Heritier Muhire
// Student Id: S1719021
package com.example.myweatherfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerviewWeatherAdapter.MyViewHolder.OnCityWeatherItemClickListener {

    RecyclerView recyclerView;
    RecyclerviewWeatherAdapter adapter;
    List<LocationWeather> cityDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityDataList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // add items for the the cityDataList
        cityDataList.add(new LocationWeather(
                "Kigali",
                R.drawable.kgl1,
                20
        ));
        cityDataList.add(new LocationWeather(
                "London",
                R.drawable.lon1,
                30
        ));
        cityDataList.add(new LocationWeather(
                "Dhaka",
                R.drawable.dha,
                23
        ));
        cityDataList.add(new LocationWeather(
                "New York",
                R.drawable.nyc1,
                32
        ));
        cityDataList.add(new LocationWeather(
                "Glasgow",
                R.drawable.gla,
                25
        ));
        cityDataList.add(new LocationWeather(
                "Oman",
                R.drawable.oman12,
                22
        ));
        cityDataList.add(new LocationWeather(
                "Port-Luis",
                R.drawable.mur,
                21
        ));

        adapter = new RecyclerviewWeatherAdapter(this, cityDataList, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {

        switch(position){
            case 0:
                Intent myIntent = new Intent(this, Another2Menu.class);
                startActivity(myIntent);
                break;

            case 1:
                Intent myIntent1 = new Intent(this, Another2Menu.class);
                startActivity(myIntent1);
                break;

            case 2:
                Intent myIntent2 = new Intent(this, Another2Menu.class);
                startActivity(myIntent2);
                break;

            case 3:
                Intent myIntent3 = new Intent(this, Another2Menu.class);
                startActivity(myIntent3);
                break;

            case 4:
                Intent myIntent4 = new Intent(this, Another2Menu.class);
                startActivity(myIntent4);
                break;

            case 5:
                Intent myIntent5 = new Intent(this, Another2Menu.class);
                startActivity(myIntent5);
                break;

            case 6:
                Intent myIntent6 = new Intent(this, Another2Menu.class);
                startActivity(myIntent6);
                break;


        }
//        if(position == 0){
//            Intent myIntent = new Intent(this, City1MainActivity.class);
//            startActivity(myIntent);
//        }else if(position == 1){
//            Intent myIntent = new Intent(this, City2MainActivity.class);
//            startActivity(myIntent);
//
//        }
//        else if(position == 2){
//            Intent myIntent3 = new Intent(this, UpdatedMenuActivity.class);
//            startActivity(myIntent3);
//
//        }
//        else {
//            Intent myIntent3 = new Intent(this, City1MainActivity.class);
//            startActivity(myIntent3);
//        }
    }
}
