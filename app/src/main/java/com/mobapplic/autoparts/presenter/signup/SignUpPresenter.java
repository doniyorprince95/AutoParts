package com.mobapplic.autoparts.presenter.signup;


import com.mobapplic.autoparts.presenter.BasePresenter;
import com.mobapplic.autoparts.view.views.signUp.SignUpView;

public interface SignUpPresenter extends BasePresenter<SignUpView> {
    void registration(String username, String password);

    interface SignUpListener {
        void onSuccess();
        void onError();
    }
}
