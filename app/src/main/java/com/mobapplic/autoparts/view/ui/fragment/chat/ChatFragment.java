package com.mobapplic.autoparts.view.ui.fragment.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobapplic.autoparts.R;

public class ChatFragment extends Fragment {

    public static ChatFragment newInstance() {
        ChatFragment chatFragment = new ChatFragment();
        Bundle args = new Bundle();
        chatFragment.setArguments(args);
        return chatFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        return view;
    }
}
