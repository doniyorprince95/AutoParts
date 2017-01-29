package com.mobapplic.autoparts.model.interactor.drawer;

import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.mobapplic.autoparts.presenter.drawer.DrawerPresenter;

public interface DrawerInteractor {

    void navigateTo(MenuItem item, DrawerLayout drawerLayout, DrawerPresenter.DrawerListener listener);

}
