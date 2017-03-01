package com.mobapplic.autoparts.view.ui.fragment.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.presenter.chat.ChatPresenter;
import com.mobapplic.autoparts.presenter.chat.ChatPresenterImpl;
import com.mobapplic.autoparts.view.adapters.chat.ChatAdapter;
import com.mobapplic.autoparts.view.views.chat.ChatView;

import io.realm.Realm;

public class ChatFragment extends Fragment implements ChatView, TextView.OnEditorActionListener, View.OnClickListener {

    private ChatPresenter mChatPresenter;
    ChatAdapter mChatAdapter;
    RecyclerView mRecyclerView;
    private Realm mRealm;
    EditText enterMsg;
    Button sendMsg;

    public static ChatFragment newInstance() {
        ChatFragment chatFragment = new ChatFragment();
        Bundle args = new Bundle();
        chatFragment.setArguments(args);
        return chatFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mChatPresenter = new ChatPresenterImpl();
        mRealm = Realm.getDefaultInstance();
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        mChatPresenter.bindView(this);
        init();
    }

    private void init() {
        enterMsg = (EditText) getActivity().findViewById(R.id.enter_message);
        enterMsg.setOnEditorActionListener(this);
        sendMsg = (Button) getActivity().findViewById(R.id.send);
        sendMsg.setOnClickListener(this);
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.rv_chat);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mChatAdapter = new ChatAdapter();
        mRecyclerView.setAdapter(mChatAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mChatPresenter.unBindView();
        mRealm.close();
    }

    private void sendMessage(String msg) {
        mChatPresenter.onSend(msg);
    }

    @Override
    public void showMessages(String message) {
        mChatAdapter.add(message);
    }

    @Override
    public void closeChat() {

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEND) {
            sendMessage(enterMsg.getText().toString().trim());
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send:
                sendMessage(enterMsg.getText().toString().trim());
                break;
        }
    }
}
