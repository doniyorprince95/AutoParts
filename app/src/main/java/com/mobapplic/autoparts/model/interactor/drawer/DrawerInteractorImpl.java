package com.mobapplic.autoparts.model.interactor.drawer;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.presenter.drawer.DrawerPresenter;
import com.mobapplic.autoparts.view.ui.fragment.car.CarInfoFragment;
import com.mobapplic.autoparts.view.ui.fragment.chat.ChatFragment;
import com.mobapplic.autoparts.view.ui.fragment.history.HistoryOrderFragment;

public class DrawerInteractorImpl implements DrawerInteractor {

    @Override
    public void navigateTo(MenuItem item, DrawerLayout drawerLayout, DrawerPresenter.DrawerListener listener) {
        switch (item.getItemId()) {
            case R.id.menu_nav_main:
                listener.openHome();
                drawerLayout.closeDrawers();
                break;
            case R.id.menu_nav_chat:
                listener.openFragment(ChatFragment.newInstance());
                break;
            case R.id.menu_nav_car:
                listener.openFragment(CarInfoFragment.newInstance());
                break;
            case R.id.menu_nav_history:
                listener.openFragment(HistoryOrderFragment.newInstance());
                break;
            case R.id.menu_nav_logout:
                listener.logOut();
                drawerLayout.closeDrawers();
                break;
            default:
                listener.openHome();
                break;
        }
        item.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
