package com.mobapplic.autoparts.view.ui.activity.signup;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.mobapplic.autoparts.view.ui.activity.main.MainActivity;
import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.presenter.signup.SignUpPresenter;
import com.mobapplic.autoparts.presenter.signup.SignUpPresenterImpl;
import com.mobapplic.autoparts.view.views.signUp.SignUpView;

public class SignUpActivity extends AppCompatActivity implements SignUpView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private SignUpPresenter mSignUpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.inputLogin);
        password = (EditText) findViewById(R.id.inputPassword);
        findViewById(R.id.btn_signup).setOnClickListener(this);

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
        mSignUpPresenter.unbindView();
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
        mSignUpPresenter.registration(username.getText().toString().trim(), password.getText().toString().trim());
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
