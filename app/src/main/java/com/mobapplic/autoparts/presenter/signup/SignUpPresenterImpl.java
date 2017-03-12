package com.mobapplic.autoparts.presenter.signup;


import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mobapplic.autoparts.App;
import com.mobapplic.autoparts.model.interactor.signup.SignUpInteractor;
import com.mobapplic.autoparts.utils.preference.AppPreference;
import com.mobapplic.autoparts.view.views.signUp.SignUpView;

import static android.content.ContentValues.TAG;

public class SignUpPresenterImpl implements SignUpPresenter {

    private SignUpInteractor mSignUpInteractor;
    private FirebaseAuth mAuth;
    private SignUpView mSignUpView;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public SignUpPresenterImpl() {
        mAuth = FirebaseAuth.getInstance();
        mSignUpInteractor = new SignUpInteractor(mAuth);
    }

    @Override
    public void bindView(SignUpView signUpView) {
        mSignUpView = signUpView;
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    AppPreference.setToken(App.getContext(), user.getUid());
                    mSignUpView.navigateToHome();
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void unBindView() {
        mSignUpView = null;
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public void registration(final String username, final String password) {
        if (username.isEmpty()) {
            mSignUpView.setUsernameError();
            return;
        }
        if (password.isEmpty()) {
            mSignUpView.setPasswordError();
            return;
        }
        if (mSignUpView != null) {
            mSignUpView.showProgress();
        }
        mSignUpInteractor.signUp(username, password, new SignUpListener() {

            @Override
            public void onSuccess() {
                if (mSignUpView != null) {
                    mSignUpView.hideProgress();
                    mSignUpView.navigateToHome();
                }
            }

            @Override
            public void onError() {
                mSignUpView.hideProgress();
                if (username.isEmpty()) {
                    mSignUpView.setUsernameError();
                }
                if (password.isEmpty()) {
                    mSignUpView.setPasswordError();
                }
                if (password.length() < 6) {
                    mSignUpView.setPasswordLengthError();
                }
            }

            @Override
            public void onLogin() {
                if (mSignUpView != null) {
                    mSignUpView.navigateToLogin();
                }
            }
        });
    }


}
