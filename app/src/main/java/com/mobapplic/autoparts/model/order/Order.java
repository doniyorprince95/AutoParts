package com.mobapplic.autoparts.model.order;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Order extends RealmObject {

    @PrimaryKey
    private int mId;
    private long mDateOrder;
    private String mOrder;
    private String mStatus;

    public Order() {
    }

    public Order(int id, long dateOrder, String order, OrderStatus status) {
        mId = id;
        mDateOrder = dateOrder;
        mOrder = order;
        mStatus = status.toString();
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
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
