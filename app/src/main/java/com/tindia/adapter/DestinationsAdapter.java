package com.tindia.adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tindia.R;
import com.tindia.activity.DetailActivity;
import com.tindia.model.Destination;

import java.util.List;

public class DestinationsAdapter extends RecyclerView.Adapter<DestinationsAdapter.ViewHolder> {

    private List<Destination> destinations;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public DestinationsAdapter(List<Destination> destinations){
        this.destinations = destinations;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_destination,parent,false);

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Destination destination = destinations.get(position);
        final CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.dest_image);
        String imageUrl = destination.getImage_url();
        Picasso.get().load(imageUrl).into(imageView);
//        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(),Integer.valueOf(destination.getImage_url()));
        TextView textView = cardView.findViewById(R.id.dest_name);
        textView.setText(destination.getDest_name());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cardView.getContext(), DetailActivity.class);
                cardView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return destinations.size();
    }
}
