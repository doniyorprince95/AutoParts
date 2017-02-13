package com.mobapplic.autoparts.view.adapters.history;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobapplic.autoparts.R;
import com.mobapplic.autoparts.model.entity.order.Order;
import com.mobapplic.autoparts.model.repository.order.OrderRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.realm.Realm;

public class HistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    List<Order> mOrderList;
    Realm mRealm;

    public HistoryAdapter(Context context, Realm realm) {
        mContext = context;
        mOrderList = new ArrayList<>();
        mRealm = realm;
        mOrderList = new OrderRepository(realm).getOrderList();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new HistoryOrderHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Order order = mOrderList.get(position);
        HistoryOrderHolder historyOrderHolder = (HistoryOrderHolder)holder;
        historyOrderHolder.bind(order);
    }

    @Override
    public int getItemCount() {
        return mOrderList.size();
    }

    private static class HistoryOrderHolder extends RecyclerView.ViewHolder {

        TextView historyPrice;
        TextView historyOrder;
        TextView historyDate;

        HistoryOrderHolder(View itemView) {
            super(itemView);
            historyPrice = (TextView) itemView.findViewById(R.id.history_price);
            historyOrder = (TextView) itemView.findViewById(R.id.history_order);
            historyDate = (TextView) itemView.findViewById(R.id.history_date);
        }

        public void bind(Order order) {
            historyPrice.setText(String.valueOf(order.getPrice()));
            historyOrder.setText(order.getOrder());
            historyDate.setText(new SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(order.getDateOrder()));
        }
    }
}
