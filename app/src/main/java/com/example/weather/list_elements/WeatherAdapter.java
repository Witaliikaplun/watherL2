package com.example.weather.list_elements;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather.R;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    ArrayList<Weather> weathers;

    public WeatherAdapter(ArrayList<Weather> weathers) {
        this.weathers = weathers;
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView desc;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.image);
            desc = (TextView) itemView.findViewById(R.id.descript);
        }
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int position) {
        weatherViewHolder.desc.setText(weathers.get(position).getDescription());
        weatherViewHolder.img.setImageResource(weathers.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return weathers.size();
    }
}
