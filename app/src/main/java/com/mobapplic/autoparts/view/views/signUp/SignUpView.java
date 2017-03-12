package com.mobapplic.autoparts.view.views.signUp;

public interface SignUpView {
    void showProgress();
    void hideProgress();
    void setPasswordLengthError();
    void setUsernameError();
    void setPasswordError();
    void navigateToHome();
    void navigateToLogin();
}
