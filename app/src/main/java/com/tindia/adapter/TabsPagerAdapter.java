package com.tindia.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.tindia.R;
import com.tindia.fragment.DetailFragment;
import com.tindia.fragment.FoodFragment;
import com.tindia.fragment.HotelFragment;
import com.tindia.fragment.TransportFragment;
import com.tindia.model.Destination;
import com.tindia.model.DetailResponse;

public class TabsPagerAdapter extends FragmentStatePagerAdapter {

    Context context;
    public DetailResponse detailResponse;
    public Destination destination;
    private String srcCity = " ";
    private String destCity = " ";
    private String date = "";

    public TabsPagerAdapter(Context context, FragmentManager fm, DetailResponse detailResponse, Destination destination) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
        this.detailResponse = detailResponse;
        this.destination = destination;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return DetailFragment.newInstance(detailResponse.getPlace(), destination);
            case 1:
                return HotelFragment.newInstance(detailResponse.getHotel(), destination);
            case 2:
                return TransportFragment.newInstance(srcCity, destCity, date);
            case 3:
                return FoodFragment.newInstance(detailResponse.getFood(), destination);
        }
        return null;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    public void setSrcCity(String srcCity) {
        this.srcCity = srcCity;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getResources().getText(R.string.detail_tab);
            case 1:
                return context.getResources().getText(R.string.hotel_tab);
            case 2:
                return context.getResources().getText(R.string.transport_tab);
            case 3:
                return context.getResources().getText(R.string.food_tab);
        }
        return null;
    }
}
