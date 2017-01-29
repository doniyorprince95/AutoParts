package com.mobapplic.autoparts.view.ui.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.presenter.drawer.DrawerPresenter;
import com.mobapplic.autoparts.presenter.drawer.DrawerPresenterImpl;
import com.mobapplic.autoparts.presenter.main.MainPresenter;
import com.mobapplic.autoparts.view.ui.activity.login.LoginActivity;
import com.mobapplic.autoparts.view.ui.activity.settings.SettingsAppActivity;
import com.mobapplic.autoparts.view.views.main.MainView;

public class MainActivity extends AppCompatActivity implements MainView,
        NavigationView.OnNavigationItemSelectedListener {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;

    MainPresenter mMainPresenter;
    DrawerPresenter mDrawerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawer = (NavigationView) findViewById(R.id.navigation_drawer);
        mDrawer.setNavigationItemSelectedListener(this);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainPresenter.bindView(this);
        mDrawerPresenter = new DrawerPresenterImpl(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMainPresenter.unBindView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showHome() {
        Log.d("MainActivity", "showHome");
    }

    @Override
    public void showSettingsApp() {
        startActivity(new Intent(this, SettingsAppActivity.class));
    }

    @Override
    public void logOut() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        mDrawerPresenter.navigationItemSelected(item, mDrawerLayout);
        return false;
    }

    @Override
    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

}
