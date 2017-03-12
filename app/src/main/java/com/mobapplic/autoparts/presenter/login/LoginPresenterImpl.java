package com.mobapplic.autoparts.presenter.login;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mobapplic.autoparts.App;
import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.model.interactor.login.LoginInteractor;
import com.mobapplic.autoparts.utils.preference.AppPreference;
import com.mobapplic.autoparts.view.views.login.LoginView;

import static android.content.ContentValues.TAG;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView mLoginView;
    private LoginInteractor loginInteractor;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public LoginPresenterImpl() {
        mAuth = FirebaseAuth.getInstance();
        this.loginInteractor = new LoginInteractor(mAuth);
    }

    @Override
    public void validateCredentials(final String username, final String password) {
        if (mLoginView != null) {
            mLoginView.showProgress();
        }

        loginInteractor.login(username, password, new OnLoginListener() {
            @Override
            public void onSuccess() {
                mLoginView.hideProgress();
                mLoginView.navigateToHome();
            }

            @Override
            public void onError() {
                mLoginView.hideProgress();
                if (username != null && username.isEmpty()) {
                    mLoginView.setUsernameError();
                }
                if (password != null && password.isEmpty()) {
                    mLoginView.setPasswordError();
                }
                if (password != null && password.length() < 6) {
                    mLoginView.setPasswordLengthError();
                } else {
                    mLoginView.setError(App.getContext().getString(R.string.login_error));
                }
            }
        });
    }

    @Override
    public void unBindView() {
        mLoginView = null;
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public void bindView(LoginView loginView) {
        mLoginView = loginView;
        mAuthListener  = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    if (AppPreference.isAuthorized(App.getContext())) {
                        AppPreference.setToken(App.getContext(), user.getUid());
                    }
                    mLoginView.navigateToHome();
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };
        mAuth.addAuthStateListener(mAuthListener);
    }


}
