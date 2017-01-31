package com.mobapplic.autoparts.presenter.reset;

import com.mobapplic.autoparts.presenter.BasePresenter;
import com.mobapplic.autoparts.view.views.reset.ResetPasswordView;

public interface ResetPasswordPresenter extends BasePresenter<ResetPasswordView> {

    void resetPassword(String userEmail);

    interface OnResetListener {
        void onSuccess();
        void onError();
    }

}
