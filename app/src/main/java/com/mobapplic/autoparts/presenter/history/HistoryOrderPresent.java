package com.mobapplic.autoparts.presenter.history;

import com.mobapplic.autoparts.presenter.BasePresenter;
import com.mobapplic.autoparts.view.views.history.HistoryOrderView;

public interface HistoryOrderPresent extends BasePresenter<HistoryOrderView> {
    void loadOrders();
}
