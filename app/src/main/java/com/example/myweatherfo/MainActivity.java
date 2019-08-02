// Names : Heritier Muhire
// Student Id: S1719021
package com.example.myweatherfo;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Member variables
    private RecyclerView mRecyclerView;
    private ArrayList<Location> mLocationsData;
    private LocationsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Initialize the ArrayLIst that will contain the data
        mLocationsData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new LocationsAdapter(this, mLocationsData);
        mRecyclerView.setAdapter(mAdapter);

        // FOR SWIPING
        /*ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper
                .SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                mLocationsData.remove(viewHolder.getAdapterPosition());
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

            }
        });

        helper.attachToRecyclerView(mRecyclerView);

*/

        //Get the data
        initializeData();
    }

    /**
     * Method for initializing the sports data from resources.
     */
    private void initializeData() {
        //Get the resources from the XML file
        String[] sportsList = getResources().getStringArray(R.array.locations_titles);
//        String[] sportsInfo = getResources().getStringArray(R.array.locations_info);

        TypedArray locationsImageResources =
                getResources().obtainTypedArray(R.array.locations_images);

        //Clear the existing data (to avoid duplication)
        mLocationsData.clear();

        //Create the ArrayList of Sports objects with the titles and information about each sport
        for(int i=0;i<sportsList.length;i++){
            mLocationsData.add(new Location(sportsList[i],
                    locationsImageResources.getResourceId(i,0)));
        }

        // HIGHLY DOUBT : clean up the data in the typed Array
        locationsImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }
}
