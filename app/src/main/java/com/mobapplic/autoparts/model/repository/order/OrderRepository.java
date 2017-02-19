package com.mobapplic.autoparts.model.repository.order;

import com.mobapplic.autoparts.model.entity.order.Order;
import com.mobapplic.autoparts.model.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class OrderRepository implements Repository<Order> {

    private Realm mRealm;

    public OrderRepository(Realm realm) {
        mRealm = realm;
    }

    @Override
    public void addObject(Order order) {
        Order o = new Order();
        o.in(order);
        mRealm.copyToRealmOrUpdate(o);
    }

    @Override
    public void deleteObjectByName(String name) {
        mRealm.beginTransaction();
        Order order = mRealm.where(Order.class).equalTo("order", name).findFirst();
        order.deleteFromRealm();
        mRealm.commitTransaction();
    }

    @Override
    public void deleteObjectByPosition(int position) {
        RealmResults<Order> realmResults = mRealm.where(Order.class).findAll();
        realmResults.deleteFromRealm(position);
    }

    @Override
    public Order getObjectByName(String name) {
        return mRealm.where(Order.class).equalTo("order", name).findFirst();
    }

    @Override
    public RealmResults<Order> getAllObjectItem() {
        return mRealm.where(Order.class).findAll();
    }

    @Override
    public void update(List<Order> orders) {
        for (Order order : orders) {
            addObject(order);
        }
    }

    public List<Order> getOrderList() {
        List<Order> list = new ArrayList<>();
        list.addAll(getAllObjectItem());
        return list;
    }
}
