package com.mobapplic.autoparts.model.entity.order;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Order extends RealmObject {

    @PrimaryKey
    private String id;
    private int price;
    private long dateOrder;
    private String order;
    private String status;

    public Order() {
    }

    public Order(String id, int price, long dateOrder, String order, OrderStatus status) {
        this.id = id;
        this.price = price;
        this.dateOrder = dateOrder;
        this.order = order;
        this.status = status.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(long dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(status);
    }

    public void setStatus(OrderStatus status) {
        this.status = status.toString();
    }

    public void in(Order order) {
        this.id = UUID.randomUUID().toString();
        this.order = order.getOrder();
        this.price = order.getPrice();
        this.dateOrder = order.getDateOrder();
        this.status = order.getStatus().toString();
    }

    public Order out() {
        Order order = new Order();
        order.setId(this.getId());
        order.setPrice(this.getPrice());
        order.setStatus(this.getStatus());
        order.setDateOrder(this.getDateOrder());
        order.setOrder(this.getOrder());
        return order;
    }
}
