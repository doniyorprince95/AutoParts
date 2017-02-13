package com.mobapplic.autoparts.view.ui.activity.chat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.view.ui.fragment.chat.ChatFragment;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChatFragment chatFragment = new ChatFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, chatFragment).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
