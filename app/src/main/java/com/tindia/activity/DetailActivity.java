package com.tindia.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.tindia.R;
import com.tindia.adapter.DetailDescAdapter;
import com.tindia.adapter.TabsPagerAdapter;
import com.tindia.model.DetailPlace;
import com.tindia.model.DetailResponse;
import com.tindia.network.ApiInterface;
import com.tindia.network.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    private final String TAG = DetailActivity.class.getSimpleName();
    TabsPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);

        pagerAdapter = new TabsPagerAdapter(this,getSupportFragmentManager());

        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);

        getDetailResponse();
    }

    private void handleResponse(DetailResponse detailResponse){
        pagerAdapter.setDetailResponse(detailResponse);
        pagerAdapter.notifyDataSetChanged();
    }

    private void getDetailResponse(){
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<DetailResponse> detailResponse = apiInterface.getDetailResponse();

        detailResponse.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                if(response.isSuccessful()){
                    handleResponse(response.body());
                }
                else {
                    Log.e(TAG, response.message());
                }
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }
}