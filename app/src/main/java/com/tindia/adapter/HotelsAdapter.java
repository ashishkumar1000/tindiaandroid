package com.tindia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tindia.R;
import com.tindia.model.Hotel;

import java.util.List;

public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.ViewHolder> {

    List<Hotel> hotelList;
    Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
        }
    }

    public HotelsAdapter(List<Hotel> hotelList,Context context){
        this.hotelList = hotelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cv = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_hotel, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Hotel hotel = hotelList.get(position);
        final View cardView = holder.view;
        ImageView imageView = cardView.findViewById(R.id.imageView_hotel);
        String imageUrl = hotel.getHotel_image();
        Picasso.get().load(imageUrl).into(imageView);
        TextView hotelName = cardView.findViewById(R.id.textView_hotelName);
        hotelName.setText(hotel.getHotel_name());
        TextView hotelAddress = cardView.findViewById(R.id.textView_hotelAddress);
        hotelAddress.setText(hotel.getHotel_address());
        TextView hotelRating = cardView.findViewById(R.id.textView_hotelRating);
        hotelRating.setText(hotel.getHotel_rating().toString() + "/5.0");
        TextView hotelPrice = cardView.findViewById(R.id.textView_hotelPrice);
        hotelPrice.setText("Rs " + String.valueOf(hotel.getHotel_price()));
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }
}
