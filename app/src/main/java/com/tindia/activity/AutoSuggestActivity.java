package com.tindia.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tindia.R;
import com.tindia.network.ApiInterface;
import com.tindia.network.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tindia.activity.DetailActivity.AUTO_SUGGEST_ACTIVITY;

public class AutoSuggestActivity extends AppCompatActivity implements View.OnClickListener, SearchView.OnQueryTextListener {

    private static final String TAG = AutoSuggestActivity.class.getSimpleName();
    private ListView cityList;
    private String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_suggest);
        type = getIntent().getStringExtra("TYPE");

        TextView back = findViewById(R.id.tv_back);

        back.setOnClickListener(this);


        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnClickListener(this);
        searchView.setOnQueryTextListener(this);

        cityList = findViewById(R.id.city_list);

        updateCityList(null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                this.handleBackPress();
                break;
            case R.id.searchView:
                this.onSearchClicked();
                break;
            default:
                Toast.makeText(this, "invalid inpjut", Toast.LENGTH_SHORT).show();

        }
    }

    private void onSearchClicked() {
        Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show();
    }

    private void updateCityList(final List<String> list) {

/*        String[] mobileArray = {"Android", "IPhone", "WindowsMobile", "Blackberry",
                "WebOS", "Ubuntu", "Windows7", "Max OS X"};*/
        if (list != null) {
            ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_listview, list.toArray());
            cityList.setAdapter(adapter);
            cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    handleBackPress(list.get(position));
                }
            });

        }
    }

    private void handleBackPress(String cityName) {
        Intent intent = new Intent();
        intent.putExtra("MESSAGE", cityName);
        intent.putExtra("TYPE", type);
        setResult(AUTO_SUGGEST_ACTIVITY, intent);
        finish();
    }

    private void handleBackPress() {
        handleBackPress("");
    }

    @Override
    public void onBackPressed() {
        handleBackPress();
    }

    private void getAutoSuggestedCities(String word) {
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        apiInterface.getAutoSuggestCity(word).enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful()) {
                    handleCityResponse(response.body());
                } else {
                    Log.e(TAG, response.message());
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }

    private void handleCityResponse(List<String> cities) {
        // final List<String> cityList = new ArrayList<>();
        updateCityList(cities);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        getAutoSuggestedCities(newText);
        return false;
    }
}