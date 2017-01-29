package com.mobapplic.autoparts.presenter.address;


import com.mobapplic.autoparts.presenter.BasePresenter;
import com.mobapplic.autoparts.view.views.address.AddressView;

public interface AddressPresenter extends BasePresenter<AddressView> {
    void loadAddress();
}
