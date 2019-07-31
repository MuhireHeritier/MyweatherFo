/**
 * created by Heritier Muhire
 * Student Id: S1719021
 *
 */
package com.example.myweatherfo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class RecyclerviewWeatherAdapter extends RecyclerView.Adapter<RecyclerviewWeatherAdapter.MyViewHolder> {
    private static final String TAG = "RecyclerviewWeatherAdap";

    private Context mContext;
    private List<LocationWeather> weatherItemsList;
    private MyViewHolder.OnCityWeatherItemClickListener mOnCityWeatherItemClickListener;

    public RecyclerviewWeatherAdapter(Context mContext, List<LocationWeather> weatherItemsList,
                                      MyViewHolder.OnCityWeatherItemClickListener onCityWeatherItemClickListener) {
        this.mContext = mContext;
        this.weatherItemsList = weatherItemsList;
        this.mOnCityWeatherItemClickListener = onCityWeatherItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_items_layout,null);
        return new MyViewHolder(view, mOnCityWeatherItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        LocationWeather weatherItems = weatherItemsList.get(position);
        myViewHolder.textViewCityName.setText(weatherItems.getCityName());
        myViewHolder.textViewCItyTemperature.setText(weatherItems.getCityTemperature()+ " \u2103");
        myViewHolder.imageViewCity.setImageDrawable(mContext.getResources().getDrawable(weatherItems.getCityImage()));


    }

    @Override
    public int getItemCount() {
        return weatherItemsList.size();
    }

    // inner class
    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RelativeLayout relativeLayout;
        CardView cardView;
        TextView textViewCityName, textViewCItyTemperature;
        ImageView imageViewCity;

        OnCityWeatherItemClickListener onCityWeatherItemClickListener;

        public MyViewHolder(@NonNull View itemView, OnCityWeatherItemClickListener onCityWeatherItemClickListener) {
            super(itemView);

            textViewCityName = itemView.findViewById(R.id.cityName);
            textViewCItyTemperature = itemView.findViewById(R.id.city_temperature);
            imageViewCity = itemView.findViewById(R.id.city_imageView);
            relativeLayout = itemView.findViewById(R.id.relative_view);
            cardView = itemView.findViewById(R.id.card_view);
            this.onCityWeatherItemClickListener = onCityWeatherItemClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCityWeatherItemClickListener.onItemClick(getAdapterPosition());
        }

        public interface OnCityWeatherItemClickListener {
            void onItemClick(int position);
        }
    }

}
