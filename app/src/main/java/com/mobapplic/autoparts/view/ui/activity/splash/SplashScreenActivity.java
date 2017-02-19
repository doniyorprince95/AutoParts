package com.mobapplic.autoparts.view.ui.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.presenter.splash.SplashPresenter;
import com.mobapplic.autoparts.presenter.splash.SplashPresenterImpl;
import com.mobapplic.autoparts.view.ui.activity.login.LoginActivity;
import com.mobapplic.autoparts.view.ui.activity.main.MainActivity;
import com.mobapplic.autoparts.view.ui.activity.signup.SignUpActivity;
import com.mobapplic.autoparts.view.views.splash.SplashView;

public class SplashScreenActivity extends AppCompatActivity implements SplashView {

    ImageView imageSplash;
    private SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageSplash = (ImageView) findViewById(R.id.imageSplash);
        mSplashPresenter = new SplashPresenterImpl();
        final Animation animation_1 = AnimationUtils.loadAnimation(this, R.anim.rotate_center);
        imageSplash.setAnimation(animation_1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSplashPresenter.bindView(this);
    }

    @Override
    public void navigateToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void navigateToSignUp() {
        startActivity(new Intent(this, SignUpActivity.class));
        finish();
    }

    @Override
    public void navigateToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSplashPresenter.unBindView();
    }
}