package com.mobapplic.autoparts.model.order;

import io.realm.RealmObject;


public class Order extends RealmObject {

    private long mDateOrder;
    private String mOrder;
    private String mStatus;

    public Order() {
    }

    public Order(long dateOrder, String order, OrderStatus status) {
        mDateOrder = dateOrder;
        mOrder = order;
        mStatus = status.toString();
    }

    public long getDateOrder() {
        return mDateOrder;
    }

    public void setDateOrder(long dateOrder) {
        mDateOrder = dateOrder;
    }

    public String getOrder() {
        return mOrder;
    }

    public void setOrder(String order) {
        mOrder = order;
    }

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(mStatus);
    }

    public void setStatus(OrderStatus status) {
        mStatus = status.toString();
    }
}
