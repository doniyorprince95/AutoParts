package com.mobapplic.autoparts.view.ui.activity.chat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.view.ui.fragment.chat.ChatFragment;

import io.realm.Realm;

public class ChatActivity extends AppCompatActivity {

    Realm mRealm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChatFragment chatFragment = new ChatFragment();
        mRealm = Realm.getDefaultInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, chatFragment).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }
}
