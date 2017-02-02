package com.mobapplic.autoparts.view.adapters.history;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class HistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;

    public HistoryAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
