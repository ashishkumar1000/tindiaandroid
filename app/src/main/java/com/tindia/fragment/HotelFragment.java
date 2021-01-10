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
import com.tindia.adapter.DetailDescAdapter;
import com.tindia.adapter.HotelsAdapter;
import com.tindia.model.Destination;
import com.tindia.model.Hotel;
import com.tindia.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HotelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelFragment extends Fragment {

    private final String TAG = DetailActivity.class.getSimpleName();
    private List<Hotel> hotelList;
    private Destination destination;
    private RecyclerView recyclerView;


    private static final String HOTEL_LIST = "HOTEL_LIST";

    public HotelFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HotelFragment newInstance(List<Hotel> hotelList, Destination destination) {
        HotelFragment fragment = new HotelFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(HOTEL_LIST, (ArrayList<? extends Parcelable>) hotelList);
        args.putParcelable(AppConstants.DEST_RESPONSE, destination);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            hotelList = getArguments().getParcelableArrayList(HOTEL_LIST);
            destination = getArguments().getParcelable(AppConstants.DEST_RESPONSE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotel, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView_hotel);
        HotelsAdapter hotelsAdapter = new HotelsAdapter(hotelList,getActivity().getApplicationContext());
        recyclerView.setAdapter(hotelsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }
}