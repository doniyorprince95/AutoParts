package com.mobapplic.autoparts.presenter.signup;


import com.mobapplic.autoparts.view.views.signUp.SignUpView;

public interface SignUpPresenter {
    void bindView(SignUpView signUpView);

    void unbindView();

    void registration(String username, String password);

    interface SignUpListener {
        void onSuccess();
        void onError();
    }
}
