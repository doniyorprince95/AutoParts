package com.mobapplic.autoparts.view.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.presenter.login.LoginPresenter;
import com.mobapplic.autoparts.presenter.login.LoginPresenterImpl;
import com.mobapplic.autoparts.view.ui.activity.main.MainActivity;
import com.mobapplic.autoparts.view.ui.activity.signup.SignUpActivity;
import com.mobapplic.autoparts.view.views.login.LoginView;

import io.realm.Realm;


public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private TextView signUp;
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter mLoginPresenter;

    private Realm mRealm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.inputLogin);
        password = (EditText) findViewById(R.id.inputPassword);
        signUp = (TextView) findViewById(R.id.signUp);
        signUp.setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
        mRealm = Realm.getInstance(this);
        mLoginPresenter = new LoginPresenterImpl();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLoginPresenter.bindView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.unBindView();
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
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void setPasswordLengthError() {
        password.setError(getString(R.string.password_length_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void setError(String errorMsg) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            mLoginPresenter.validateCredentials(username.getText().toString(), password.getText().toString());
        }
        if (v.getId() == R.id.signUp) {
            startActivity(new Intent(this, SignUpActivity.class));
            finish();
        }
    }
}
