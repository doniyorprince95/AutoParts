package com.mobapplic.autoparts.presenter.splash;

import com.mobapplic.autoparts.App;
import com.mobapplic.autoparts.utils.preference.AppPreference;
import com.mobapplic.autoparts.view.views.splash.SplashView;

public class SplashPresenterImpl implements SplashPresenter {

    private SplashView mSplashView;

    public SplashPresenterImpl() {
    }

    @Override
    public void bindView(SplashView view) {
        mSplashView = view;
        if(!AppPreference.isAuthorized(App.getContext())) {
            mSplashView.navigateToSignUp();
        } else {
            mSplashView.navigateToLogin();
        }
    }

    @Override
    public void unBindView() {
        mSplashView = null;
    }
}
