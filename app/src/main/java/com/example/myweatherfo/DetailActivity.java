/**
 * created by Heritier Muhire
 * Student Id: S1719021
 */
package com.example.myweatherfo;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {


    Toolbar toolbar;
    TabLayout tabLayout;
    TabItem tabDay1;
    TabItem tabDay2;
    ViewPagerAdapter pageAdapter;
    TabItem tabDay3;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Pass data from activity to fragment
        Bundle bundle = new Bundle();
        bundle.putString("params", "My String data");
        // set MyFragment Arguments
        Day1Fragment fragment = new Day1Fragment();
        fragment.setArguments(bundle);


        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);
        tabLayout = findViewById(R.id.tablayout);
        tabDay1 = findViewById(R.id.tabDay1);
        tabDay2 = findViewById(R.id.tabDay2);
        tabDay3 = findViewById(R.id.tabDay3);

        TextView locationTitle = (TextView)findViewById(R.id.cityTitleDetail);
        locationTitle.setText(getIntent().getStringExtra("title"));
        viewPager = findViewById(R.id.viewPager_id);

        pageAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new Day1Fragment(),"Day 1");
        pageAdapter.addFragment(new Day2Fragment(),"Day 2");
        pageAdapter.addFragment(new Day3Fragment(),"Day 3");



//        pageAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setupWithViewPager(viewPager);

//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//
//                if (tab.getPosition() == 1) {
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        getWindow().setStatusBarColor(ContextCompat.getColor(DetailActivity.this,
//                                R.color.colorAccent));
//                    }
//                } else if (tab.getPosition() == 2) {
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        getWindow().setStatusBarColor(ContextCompat.getColor(DetailActivity.this,
//                                android.R.color.darker_gray));
//                    }
//                } else {
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        getWindow().setStatusBarColor(ContextCompat.getColor(DetailActivity.this,
//                                R.color.colorPrimaryDark));
//                    }
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//
    }


//    public void callBackData(String[] result) {
//        temperature.setText((Float.parseFloat(result[2]) - 273) + " degree Celcius" );
//        humidity.setText(result[0] + " %");
//        pressure.setText(result[1] + " hPa");
//        country.setText(result[4]);
//        location.setText(result[3]);
//        return;
//
//    }
}
