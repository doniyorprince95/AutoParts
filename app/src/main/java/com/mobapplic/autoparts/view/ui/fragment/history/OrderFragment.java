package com.mobapplic.autoparts.view.ui.fragment.history;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.view.views.history.OrderView;


public class OrderFragment extends Fragment implements OrderView {

    public static OrderFragment newInstance(int id) {
        OrderFragment orderFragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putInt("orderId", id);
        orderFragment.setArguments(args);
        return orderFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        return view;
    }
}
