package com.tindia.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tindia.R;

import java.util.List;

import static com.tindia.activity.DetailActivity.AUTO_SUGGEST_ACTIVITY;

public class AutoSuggestActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView cityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_suggest);

        TextView back = findViewById(R.id.tv_back);

        back.setOnClickListener(this);


        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnClickListener(this);

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

    private void updateCityList(List<String> list) {

        String[] mobileArray = {"Android", "IPhone", "WindowsMobile", "Blackberry",
                "WebOS", "Ubuntu", "Windows7", "Max OS X"};
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_listview, mobileArray);
        cityList.setAdapter(adapter);
    }

    private void handleBackPress() {
        Intent intent = new Intent();
        intent.putExtra("MESSAGE", "This message is from Auto suggest activity");
        setResult(AUTO_SUGGEST_ACTIVITY, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        handleBackPress();
    }
}