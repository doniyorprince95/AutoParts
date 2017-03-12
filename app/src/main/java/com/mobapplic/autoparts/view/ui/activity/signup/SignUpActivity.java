package com.mobapplic.autoparts.view.ui.activity.signup;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.presenter.signup.SignUpPresenter;
import com.mobapplic.autoparts.presenter.signup.SignUpPresenterImpl;
import com.mobapplic.autoparts.view.ui.activity.login.LoginActivity;
import com.mobapplic.autoparts.view.ui.activity.main.MainActivity;
import com.mobapplic.autoparts.view.views.signUp.SignUpView;

import io.realm.Realm;

public class SignUpActivity extends AppCompatActivity implements SignUpView, View.OnClickListener {

    private TextView logIn;
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private SignUpPresenter mSignUpPresenter;

    private Realm mRealm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.inputLogin);
        password = (EditText) findViewById(R.id.inputPassword);
        logIn = (TextView) findViewById(R.id.logIn) ;
        logIn.setOnClickListener(this);
        ((Button)findViewById(R.id.btn_signup)).setOnClickListener(this);
        mRealm = Realm.getDefaultInstance();
        mSignUpPresenter = new SignUpPresenterImpl();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSignUpPresenter.bindView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSignUpPresenter.unBindView();
        mRealm.close();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setPasswordLengthError() {
        password.setError(getString(R.string.password_length_error));
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signup:
                mSignUpPresenter.registration(username.getText().toString().trim(), password.getText().toString().trim());
                break;
            case R.id.logIn:
                navigateToLogin();
        }
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void navigateToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
