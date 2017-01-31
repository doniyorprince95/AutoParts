package com.mobapplic.autoparts.view.ui.activity.reset;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.presenter.reset.ResetPasswordPresenter;
import com.mobapplic.autoparts.presenter.reset.ResetPasswordPresenterImpl;
import com.mobapplic.autoparts.view.views.reset.ResetPasswordView;

public class ResetPassword extends AppCompatActivity implements ResetPasswordView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    Button btnResetPassword;

    ResetPasswordPresenter mResetPasswordPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.reset_inputLogin);
        btnResetPassword = (Button) findViewById(R.id.btn_reset_password);
        btnResetPassword.setOnClickListener(this);
        mResetPasswordPresenter = new ResetPasswordPresenterImpl();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mResetPasswordPresenter.bindView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mResetPasswordPresenter.unBindView();
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
    public void setError(String errorMsg) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_reset_password) {
            mResetPasswordPresenter.resetPassword(username.getText().toString());
        }
    }
}
