package com.tindia.activity;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.tindia.R;
import com.tindia.adapter.TabsPagerAdapter;
import com.tindia.model.Destination;
import com.tindia.model.DetailResponse;
import com.tindia.network.ApiInterface;
import com.tindia.network.ServiceGenerator;
import com.tindia.utils.AppConstants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    private final String TAG = DetailActivity.class.getSimpleName();
    TabsPagerAdapter pagerAdapter;
    ProgressBar progressBarDetail;
    Destination destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // init city id
        destination = getIntent().getExtras().getParcelable(AppConstants.DEST_RESPONSE);
        int cityId = destination.getId();

        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        progressBarDetail = findViewById(R.id.progressBarDetail);
        setSupportActionBar(toolbar);
        getDetailResponse(cityId);
    }

    private void handleResponse(DetailResponse detailResponse) {
        pagerAdapter = new TabsPagerAdapter(this, getSupportFragmentManager(), detailResponse, destination);
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
        progressBarDetail.setVisibility(View.GONE);
        pagerAdapter.notifyDataSetChanged();
    }

    private void getDetailResponse(int cityId) {
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<DetailResponse> detailResponse = apiInterface.getDetailResponse(cityId);

        detailResponse.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                if (response.isSuccessful()) {
                    handleResponse(response.body());
                } else {
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