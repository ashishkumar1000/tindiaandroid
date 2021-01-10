package com.tindia.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tindia.R;


public class TransportFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private OnTransportFragmentInteractionListener context;
    private String TAG = TransportFragment.class.getSimpleName();

    // TODO: Rename and change types of parameters
    private String srcCity;
    private String destCity;
    private String date;

    private TextView srcCityView;
    private TextView destCityView;
    private CalendarView cv_calender;

    public TransportFragment() {
        // Required empty public constructor
    }


    public static TransportFragment newInstance(String srcCity, String destCity, String date) {
        TransportFragment fragment = new TransportFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, srcCity);
        args.putString(ARG_PARAM2, destCity);
        args.putString(ARG_PARAM3, date);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            this.context = (OnTransportFragmentInteractionListener) context;
        } catch (Exception e) {
            Log.d(TAG, "Activity must implement OnTransportFragmentInteractionListener ");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            srcCity = getArguments().getString(ARG_PARAM1);
            destCity = getArguments().getString(ARG_PARAM2);
            date = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transport, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.rl_to).setOnClickListener(this);
        view.findViewById(R.id.rl_src).setOnClickListener(this);

        srcCityView = view.findViewById(R.id.tv_src_city);
        destCityView = view.findViewById(R.id.tv_dest_city);
        cv_calender = view.findViewById(R.id.cv_calender);

        srcCityView.setText(srcCity.toUpperCase());
        destCityView.setText(destCity.toUpperCase());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_to:
                context.openAutoSuggestActivity(SearchType.DEST);
                break;
            case R.id.rl_src:
                context.openAutoSuggestActivity(SearchType.SRC);
                break;
            default:
        }

    }


    public interface OnTransportFragmentInteractionListener {
        public void openAutoSuggestActivity(SearchType type);

        public void openSearchButtonClick();
    }

    public enum SearchType {
        SRC, DEST
    }
}