package com.mobapplic.autoparts.view.views.reset;

public interface ResetPasswordView {
    void showProgress();
    void hideProgress();
    void setUsernameError();
    void setError(String errorMsg);
}
