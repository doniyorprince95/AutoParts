package com.mobapplic.autoparts.presenter.chat;


import com.mobapplic.autoparts.presenter.BasePresenter;
import com.mobapplic.autoparts.view.views.chat.ChatView;

public interface ChatPresenter extends BasePresenter<ChatView> {
    void onStart();
    void onSend();
    void onRefresh();
}
