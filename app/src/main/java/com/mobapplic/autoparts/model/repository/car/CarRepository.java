package com.mobapplic.autoparts.model.repository.car;

import com.mobapplic.autoparts.model.entity.car.Car;
import com.mobapplic.autoparts.model.repository.Repository;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class CarRepository implements Repository<Car> {

    private Realm mRealm;

    public CarRepository(Realm realm) {
        mRealm = realm;
    }

    @Override
    public void addObject(Car car) {
        mRealm.beginTransaction();
        Car c = mRealm.where(Car.class).findFirst();
        c.setId(UUID.randomUUID().toString());
        c.setMark(car.getMark());
        c.setModel(car.getModel());
        c.setEngineCapacity(car.getEngineCapacity());
        c.setDate(car.getDate());
        c.setBody(car.getBody());
        c.setVIN(car.getVIN());
        mRealm.commitTransaction();
    }

    @Override
    public void deleteObjectByName(String name) {
        mRealm.beginTransaction();
        Car car = mRealm.where(Car.class).equalTo("model", name).findFirst();
        car.removeFromRealm();
        mRealm.commitTransaction();
    }

    @Override
    public void deleteObjectByPosition(int position) {
        mRealm.beginTransaction();
        RealmResults<Car> realmResults = mRealm.where(Car.class).findAll();
        realmResults.remove(position);
        mRealm.commitTransaction();
    }

    @Override
    public Car getObjectByName(String name) {
        return mRealm.where(Car.class).equalTo("model", name).findFirst();
    }

    @Override
    public RealmResults getAllObjectItem() {
        return mRealm.where(Car.class).findAll();
    }
}
