package com.mobapplic.autoparts.view.views.login;

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUsernameError();
    void setPasswordError();
    void setPasswordLengthError();
    void navigateToHome();
    void setError(String errorMsg);
}
