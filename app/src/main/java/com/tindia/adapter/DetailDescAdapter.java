package com.tindia.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tindia.R;
import com.tindia.fragment.DetailFragment;
import com.tindia.model.DetailPlace;
import com.tindia.model.DetailResponse;

import java.util.List;

public class DetailDescAdapter extends RecyclerView.Adapter<DetailDescAdapter.ViewHolder> {

    private List<DetailPlace> detailPlaces;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public DetailDescAdapter(List<DetailPlace> detailPlaces){
        this.detailPlaces = detailPlaces;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_detailplace,parent,false);

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DetailPlace detailPlace = detailPlaces.get(position);
        final CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.imageView_place);
        String imageUrl = detailPlace.getPlace_image();
        Picasso.get().load(imageUrl).into(imageView);
        TextView placeName = cardView.findViewById(R.id.textView_city);
        placeName.setText(detailPlace.getPlace_name());
        TextView placeDesc = cardView.findViewById(R.id.textView_cityDesc);
        placeDesc.setText(detailPlace.getPlace_desc());
    }

    @Override
    public int getItemCount() {
        return detailPlaces.size();
    }
}
