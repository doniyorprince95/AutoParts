package com.mobapplic.autoparts.presenter.history;

import com.mobapplic.autoparts.model.interactor.history.HistoryInteractor;
import com.mobapplic.autoparts.view.views.history.HistoryOrderView;

public class HistoryOrderPresentImpl implements HistoryOrderPresent {

    HistoryOrderView mHistoryView;
    HistoryInteractor mHistoryInteractor;

    public HistoryOrderPresentImpl(HistoryOrderView historyView) {
        mHistoryView = historyView;
        mHistoryInteractor = new HistoryInteractor();
    }

    @Override
    public void bindView(HistoryOrderView view) {
        mHistoryView = view;
    }

    @Override
    public void unBindView() {
        mHistoryView = null;
    }

    @Override
    public void loadOrders() {
        mHistoryInteractor.loadHistoryOrder();
    }
}
