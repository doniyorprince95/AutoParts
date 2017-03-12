package com.mobapplic.autoparts.presenter.drawer;

import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.mobapplic.autoparts.model.interactor.drawer.DrawerInteractorImpl;
import com.mobapplic.autoparts.model.interactor.signup.SignUpInteractor;
import com.mobapplic.autoparts.view.views.drawer.DrawerView;

public class DrawerPresenterImpl implements DrawerPresenter, DrawerPresenter.DrawerListener {

    private DrawerInteractorImpl drawerInteractor;
    private DrawerView drawerView;
    private SignUpInteractor mSignUpInteractor;

    public DrawerPresenterImpl(DrawerView drawerView) {
        this.drawerView = drawerView;
        drawerInteractor = new DrawerInteractorImpl();
    }

    @Override
    public void navigationItemSelected(MenuItem item, DrawerLayout drawerLayout) {
        drawerInteractor.navigateTo(item, drawerLayout, this);
    }

    @Override
    public void logOut() {
        mSignUpInteractor = new SignUpInteractor(FirebaseAuth.getInstance());
        mSignUpInteractor.signOut();
        drawerView.logOut();
    }

    @Override
    public void openHome() {
        drawerView.showHome();
    }

    @Override
    public void openFragment(Fragment fragment) {
        drawerView.setFragment(fragment);
    }

}
