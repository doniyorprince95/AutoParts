package com.mobapplic.autoparts.presenter.signup;


import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mobapplic.autoparts.model.interactor.signup.SignUpInteractor;
import com.mobapplic.autoparts.view.views.signUp.SignUpView;

import io.realm.Realm;

import static android.content.ContentValues.TAG;

public class SignUpPresenterImpl implements SignUpPresenter {

    SignUpInteractor mSignUpInteractor;
    private FirebaseAuth mAuth;
    SignUpView mSignUpView;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public SignUpPresenterImpl(Realm realm) {
        mAuth = FirebaseAuth.getInstance();
        mSignUpInteractor = new SignUpInteractor(mAuth, realm);
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
                if (username != null && username.isEmpty()) {
                    mSignUpView.setUsernameError();
                }
                if (password != null && password.isEmpty()) {
                    mSignUpView.setPasswordError();
                }
                if (password != null && password.length() < 6) {
                    mSignUpView.setPasswordLengthError();
                }
            }
        });
    }


}
