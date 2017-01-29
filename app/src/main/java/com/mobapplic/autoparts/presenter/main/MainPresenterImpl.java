package com.mobapplic.autoparts.presenter.main;

import com.mobapplic.autoparts.view.views.main.MainView;

public class MainPresenterImpl implements MainPresenter {

    MainView mMainView;

    public MainPresenterImpl() {
    }

    @Override
    public void bindView(MainView mainView) {
        mMainView = mainView;
    }

    @Override
    public void unBindView() {
        mMainView = null;
    }

}
