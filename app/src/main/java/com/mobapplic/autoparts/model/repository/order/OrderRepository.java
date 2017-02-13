package com.mobapplic.autoparts.model.repository.order;

import com.mobapplic.autoparts.model.entity.order.Order;
import com.mobapplic.autoparts.model.repository.Repository;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class OrderRepository implements Repository<Order> {

    private Realm mRealm;

    public OrderRepository(Realm realm) {
        mRealm = realm;
    }

    @Override
    public void addObject(Order order) {
        mRealm.beginTransaction();
        Order o = mRealm.createObject(Order.class);
        o.setId(UUID.randomUUID().toString());
        o.setOrder(o.getOrder());
        o.setDateOrder(order.getDateOrder());
        o.setStatus(order.getStatus());
        mRealm.commitTransaction();
    }

    @Override
    public void deleteObjectByName(String name) {
        mRealm.beginTransaction();
        Order order = mRealm.where(Order.class).equalTo("order", name).findFirst();
        order.removeFromRealm();
        mRealm.commitTransaction();
    }

    @Override
    public void deleteObjectByPosition(int position) {
        mRealm.beginTransaction();
        RealmResults<Order> realmResults = mRealm.where(Order.class).findAll();
        realmResults.remove(position);
        mRealm.commitTransaction();
    }

    @Override
    public Order getObjectByName(String name) {
        return mRealm.where(Order.class).equalTo("order", name).findFirst();
    }

    @Override
    public RealmResults getAllObjectItem() {
        return mRealm.where(Order.class).findAll();
    }
}
