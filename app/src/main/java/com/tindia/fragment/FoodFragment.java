package com.tindia.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tindia.R;
import com.tindia.activity.DetailActivity;
import com.tindia.adapter.FoodsAdapter;
import com.tindia.model.Destination;
import com.tindia.model.Food;
import com.tindia.network.ApiInterface;
import com.tindia.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodFragment extends Fragment {

    private final String TAG = DetailActivity.class.getSimpleName();
    private List<Food> foodList;
    private Destination destination;
    private RecyclerView recyclerView;

    private static final String FOOD_LIST = "FOOD_LIST";

    public FoodFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodFragment newInstance(List<Food> foodList, Destination destination) {
        FoodFragment fragment = new FoodFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(FOOD_LIST, (ArrayList<? extends Parcelable>) foodList);
        args.putParcelable(AppConstants.DEST_RESPONSE,destination);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            foodList = getArguments().getParcelableArrayList(FOOD_LIST);
            destination = getArguments().getParcelable(AppConstants.DEST_RESPONSE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView_food);
        FoodsAdapter foodsAdapter = new FoodsAdapter(foodList,getActivity().getApplicationContext());
        recyclerView.setAdapter(foodsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }
}