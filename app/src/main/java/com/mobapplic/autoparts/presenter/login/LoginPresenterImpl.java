package com.mobapplic.autoparts.presenter.login;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mobapplic.autoparts.App;
import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.model.interactor.login.LoginInteractor;
import com.mobapplic.autoparts.view.views.login.LoginView;

import static android.content.ContentValues.TAG;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginInteractor loginInteractor;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public LoginPresenterImpl() {
        mAuth = FirebaseAuth.getInstance();
        this.loginInteractor = new LoginInteractor(mAuth);
    }

    @Override
    public void validateCredentials(final String username, final String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password, new OnLoginListener() {
            @Override
            public void onSuccess() {
                loginView.hideProgress();
                loginView.navigateToHome();
            }

            @Override
            public void onError() {
                loginView.hideProgress();
                if (username != null && username.isEmpty()) {
                    loginView.setUsernameError();
                }
                if (password != null && password.isEmpty()) {
                    loginView.setPasswordError();
                }
                if (password != null && password.length() < 6) {
                    loginView.setPasswordError();
                } else {
                    loginView.setError(App.getContext().getString(R.string.login_error));
                }
            }
        });
    }

    @Override
    public void unBindView() {
        loginView = null;
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public void bindView(LoginView loginView) {
        this.loginView = loginView;
        mAuthListener  = new FirebaseAuth.AuthStateListener() {
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


}
