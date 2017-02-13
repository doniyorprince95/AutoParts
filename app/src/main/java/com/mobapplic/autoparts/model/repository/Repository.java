package com.mobapplic.autoparts.model.repository;


import io.realm.RealmResults;

public interface Repository<T> {
    void addObject(T obj);
    void deleteObjectByName(String name);
    void deleteObjectByPosition(int position);
    T getObjectByName(String name);
    RealmResults getAllObjectItem();
}
