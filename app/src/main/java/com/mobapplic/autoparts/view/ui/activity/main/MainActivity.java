package com.mobapplic.autoparts.view.ui.activity.main;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobapplic.autoparts.R;

public class MainActivity extends AppCompatActivity {

    private NavigationView mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawer = (NavigationView) findViewById(R.id.navigation_drawer);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
