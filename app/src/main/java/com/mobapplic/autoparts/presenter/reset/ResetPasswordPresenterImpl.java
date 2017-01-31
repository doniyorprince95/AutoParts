package com.mobapplic.autoparts.presenter.reset;

import com.google.firebase.auth.FirebaseAuth;
import com.mobapplic.autoparts.model.interactor.reset.ResetPasswordInteractor;
import com.mobapplic.autoparts.view.views.reset.ResetPasswordView;

public class ResetPasswordPresenterImpl implements ResetPasswordPresenter {

    ResetPasswordView mResetPasswordView;
    ResetPasswordInteractor mResetPasswordInteractor;
    FirebaseAuth mAuth;

    public ResetPasswordPresenterImpl() {
        mAuth = FirebaseAuth.getInstance();
        mResetPasswordInteractor = new ResetPasswordInteractor(mAuth);
    }

    @Override
    public void bindView(ResetPasswordView view) {
        mResetPasswordView = view;
    }

    @Override
    public void unBindView() {

    }

    @Override
    public void resetPassword(final String userEmail) {
        mResetPasswordView.showProgress();
        mResetPasswordInteractor.resetPassword(userEmail, new OnResetListener() {
            @Override
            public void onSuccess() {
                mResetPasswordView.hideProgress();

            }

            @Override
            public void onError() {
                mResetPasswordView.hideProgress();
                if (userEmail.isEmpty()) {
                    mResetPasswordView.setUsernameError();
                }
            }
        });
    }
}
