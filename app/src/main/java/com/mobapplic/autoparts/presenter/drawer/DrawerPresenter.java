package com.mobapplic.autoparts.presenter.drawer;

import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

public interface DrawerPresenter {
    void navigationItemSelected(MenuItem item, DrawerLayout drawerLayout);

    interface DrawerListener {
        void openHome();
        void openFragment(Fragment fragment);
        void openSettingsApp();
        void logOut();
    }
}
