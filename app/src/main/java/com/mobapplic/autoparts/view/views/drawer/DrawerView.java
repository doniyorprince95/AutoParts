package com.mobapplic.autoparts.view.views.drawer;

import android.support.v4.app.Fragment;

public interface DrawerView {
    void showHome();
//    void showChat();
//    void showCarInfo();
//    void showHistory();
    void showSettingsApp();
    void logOut();

    void setFragment(Fragment fragment);
}
