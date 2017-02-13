package com.mobapplic.autoparts.view.ui.fragment.history;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.presenter.history.HistoryOrderPresent;
import com.mobapplic.autoparts.presenter.history.HistoryOrderPresentImpl;
import com.mobapplic.autoparts.view.adapters.history.HistoryAdapter;
import com.mobapplic.autoparts.view.ui.activity.login.LoginActivity;
import com.mobapplic.autoparts.view.ui.activity.main.MainActivity;
import com.mobapplic.autoparts.view.ui.activity.settings.SettingsAppActivity;
import com.mobapplic.autoparts.view.views.drawer.DrawerView;
import com.mobapplic.autoparts.view.views.history.HistoryOrderView;

import io.realm.Realm;

import static android.R.attr.id;

public class HistoryOrderFragment extends Fragment implements HistoryOrderView, DrawerView {

    String TAG = "HistoryOrder";

    RecyclerView mRecyclerView;
    HistoryAdapter mHistoryAdapter;

    HistoryOrderPresent mHistoryPresent;
    private Realm mRealm;

    public static HistoryOrderFragment newInstance() {
        HistoryOrderFragment historyFragment = new HistoryOrderFragment();
        Bundle args = new Bundle();
        historyFragment.setArguments(args);
        return historyFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        mRealm = Realm.getDefaultInstance();
        mHistoryPresent = new HistoryOrderPresentImpl(this);
        mHistoryPresent.bindView(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        init();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mHistoryPresent.unBindView();
        mRealm.close();
    }

    private void init() {
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.rv_history);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mHistoryAdapter = new HistoryAdapter(getActivity(), mRealm);
        mRecyclerView.setAdapter(mHistoryAdapter);
        mHistoryPresent.loadOrders();
    }

    @Override
    public void showOrders() {
        OrderFragment orderFragment = OrderFragment.newInstance(id);
        setFragment(orderFragment);
//        getFragmentManager().beginTransaction().replace(R.id.container, OrderFragment.newInstance(id)).addToBackStack(TAG).commit();
    }

    @Override
    public void showHome() {
        startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
    }

    @Override
    public void showSettingsApp() {
        startActivity(new Intent(getActivity(), SettingsAppActivity.class));
        getActivity().finish();
    }

    @Override
    public void logOut() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
        getActivity().finish();
    }

    @Override
    public void setFragment(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.addToBackStack(TAG);
        ft.commit();
    }
}
