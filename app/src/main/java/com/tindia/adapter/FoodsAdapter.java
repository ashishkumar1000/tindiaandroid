package com.tindia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tindia.R;
import com.tindia.model.Food;
import com.tindia.model.Hotel;

import java.util.List;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.ViewHolder> {

    List<Food> foodList;
    Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
        }
    }

    public FoodsAdapter(List<Food> foodList,Context context){
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cv = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_food, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Food food = foodList.get(position);
        final View cardView = holder.view;
        ImageView imageView = cardView.findViewById(R.id.imageView_food);
        String imageUrl = food.getFood_image();
        Picasso.get().load(imageUrl).into(imageView);
        TextView foodName = cardView.findViewById(R.id.textView_foodName);
        foodName.setText(food.getFood_name());
        TextView foodDesc = cardView.findViewById(R.id.textView_foodDesc);
        foodDesc.setText(food.getFood_desc());
        TextView foodRating = cardView.findViewById(R.id.textView_foodRating);
        foodRating.setText(food.getFood_rating().toString() + " /5.0");
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
