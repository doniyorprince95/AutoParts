package com.mobapplic.autoparts.view.adapters.chat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobapplic.autoparts.R;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    List<String> messages;

    public ChatAdapter() {
        messages = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_right, parent, false);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_left, parent, false);
                break;
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_right, parent, false);
                break;
        }
        return new ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChatHolder chatHolder = (ChatHolder) holder;
        chatHolder.bind(messages.get(position));
    }

    public void add(String message) {
        this.messages.add(message);
        notifyDataSetChanged();
    }

    public void update(List<String> messages) {
        this.messages.clear();
        this.messages.addAll(messages);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    private class ChatHolder extends RecyclerView.ViewHolder {

        TextView msg;

        public ChatHolder(View view) {
            super(view);
            msg = (TextView) view.findViewById(R.id.message);
        }

        public void bind(String s) {
            msg.setText(s.trim());
        }
    }
}
