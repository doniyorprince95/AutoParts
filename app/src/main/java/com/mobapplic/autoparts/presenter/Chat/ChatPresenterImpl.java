package com.mobapplic.autoparts.presenter.chat;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.mobapplic.autoparts.view.views.chat.ChatView;

import java.net.URISyntaxException;

public class ChatPresenterImpl implements ChatPresenter {

    private ChatView mChatView;
    private Socket mSocket;

    public ChatPresenterImpl() {
        try {
            mSocket = IO.socket("http://chat.socket.io");
        } catch (URISyntaxException e) {}
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onSend(String message) {
        mChatView.showMessages(message);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void bindView(ChatView view) {
        mChatView = view;
        mSocket.connect();
        mSocket.emit("add user", "new user");
    }

    @Override
    public void unBindView() {
        mChatView = null;
        mSocket.disconnect();
    }
}
