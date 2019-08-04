/**
 * created by Heritier Muhire
 * Student Id: S1719021
 *
 */
package com.example.myweatherfo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myweatherfo.model.Location;

import java.util.ArrayList;


/***
 * The adapter class for the RecyclerView, contains the sports data
 */
class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.ViewHolder>  {

    //Member variables
    private ArrayList<Location> mLocationsData;
    private Context mContext;

    /**
     * Constructor that passes in the sports data and the context
     * @param locationsData ArrayList containing the sports data
     * @param context Context of the application
     */
    LocationsAdapter(Context context, ArrayList<Location> locationsData) {
        this.mLocationsData = locationsData;
        this.mContext = context;
    }


    /**
     * Required method for creating the viewholder objects.
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly create ViewHolder.
     */
    @Override
    public LocationsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    /**
     * Required method that binds the data to the viewholder.
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(LocationsAdapter.ViewHolder holder, int position) {
        //Get current location
        Location currentLocation = mLocationsData.get(position % mLocationsData.size());

        //Populate the textviews with data
        holder.bindTo(currentLocation);
        Glide.with(mContext).load(currentLocation.getImageResource()).into(holder.mLocationsImage);


    }
    /**
     * Required method for determining the size of the data set.
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    /**
     * ViewHolder class that represents each row of data in the RecyclerView
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //Member Variables for the TextViews
        private TextView mCityNameText;
        //private TextView mInfoText;
        private ImageView mLocationsImage;

        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         * @param itemView The rootview of the list_item.xml layout file
         */
        ViewHolder(View itemView) {
            super(itemView);

            //Initialize the views
            mCityNameText = (TextView)itemView.findViewById(R.id.title);

            mLocationsImage = (ImageView) itemView.findViewById(R.id.locationsImage);

            itemView.setOnClickListener(this);
        }

        void bindTo(Location currentLocation){
            //Populate the textviews with data
            mCityNameText.setText(currentLocation.getCityName());

        }

        @Override
        public void onClick(View view) {

            Location currentLocation = mLocationsData.get(getAdapterPosition() % mLocationsData.size());
            Intent detailIntent = new Intent(mContext, MenuActivity.class);
            detailIntent.putExtra("title", currentLocation.getCityName());

            mContext.startActivity(detailIntent);

        }
    }
}

