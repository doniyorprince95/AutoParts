package com.mobapplic.autoparts.presenter.main;

import com.mobapplic.autoparts.model.interactor.main.MainInteractor;
import com.mobapplic.autoparts.view.views.main.MainView;

public class MainPresenterImpl implements MainPresenter {

    private MainView mMainView;
    private MainInteractor mMainInteractor;

    public MainPresenterImpl() {
        mMainInteractor = new MainInteractor();
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
