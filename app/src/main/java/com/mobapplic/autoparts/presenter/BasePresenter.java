package com.mobapplic.autoparts.presenter;

public interface BasePresenter<T> {
    void bindView(T view);
    void unBindView();
}
