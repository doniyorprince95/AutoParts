package com.mobapplic.autoparts.view.views.drawer;

import android.support.v4.app.Fragment;

public interface DrawerView {
    void showHome();
    void showSettingsApp();
    void logOut();

    void setFragment(Fragment fragment);
}
