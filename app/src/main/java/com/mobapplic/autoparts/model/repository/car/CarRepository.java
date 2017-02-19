package com.mobapplic.autoparts.model.repository.car;

import com.mobapplic.autoparts.model.entity.car.Car;
import com.mobapplic.autoparts.model.repository.Repository;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CarRepository implements Repository<Car> {

    private Realm mRealm;

    public CarRepository(Realm realm) {
        mRealm = realm;
    }

    @Override
    public void addObject(Car car) {
        Car c = new Car();
        c.in(car);
        mRealm.copyToRealmOrUpdate(c);
    }

    @Override
    public void deleteObjectByName(String name) {
        mRealm.beginTransaction();
        Car car = mRealm.where(Car.class).equalTo("model", name).findFirst();
        car.deleteFromRealm();
        mRealm.commitTransaction();
    }

    @Override
    public void deleteObjectByPosition(int position) {
        RealmResults<Car> realmResults = mRealm.where(Car.class).findAll();
        realmResults.deleteFromRealm(position);
    }

    @Override
    public Car getObjectByName(String name) {
        return mRealm.where(Car.class).equalTo("model", name).findFirst();
    }

    @Override
    public RealmResults getAllObjectItem() {
        return mRealm.where(Car.class).findAll();
    }

    @Override
    public void update(List<Car> cars) {
        for (Car car : cars) {
            addObject(car);
        }
    }
}
