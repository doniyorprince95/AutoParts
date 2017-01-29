package com.mobapplic.autoparts.view.ui.fragment.car;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobapplic.autoparts.R;

public class CarInfoFragment extends Fragment {

    public static CarInfoFragment newInstance() {
        CarInfoFragment carInfoFragment = new CarInfoFragment();
        Bundle args = new Bundle();
        carInfoFragment.setArguments(args);
        return carInfoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_info, container, false);
        return view;
    }


}
