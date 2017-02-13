package com.mobapplic.autoparts.model.repository.user;


import com.mobapplic.autoparts.model.entity.user.User;
import com.mobapplic.autoparts.model.repository.Repository;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class UserRepository implements Repository<User> {

    private Realm mRealm;

    public UserRepository(Realm realm) {
        mRealm = realm;
    }

    @Override
    public void addObject(User user) {
        mRealm.beginTransaction();
        User u = mRealm.createObject(User.class);
        u.setId(UUID.randomUUID().toString());
        u.setUserName(u.getUserName());
        u.setPassword(u.getPassword());
        mRealm.commitTransaction();
    }

    @Override
    public void deleteObjectByName(String userName) {
        mRealm.beginTransaction();
        User user = mRealm.where(User.class).equalTo("userName", userName).findFirst();
        user.removeFromRealm();
        mRealm.commitTransaction();
    }

    @Override
    public void deleteObjectByPosition(int position) {
        mRealm.beginTransaction();
        RealmQuery query = mRealm.where(User.class);
        RealmResults results = query.findAll();
        results.remove(position);
        mRealm.commitTransaction();
    }

    @Override
    public User getObjectByName(String userName) {
        return mRealm.where(User.class).equalTo("userName", userName).findFirst();
    }

    @Override
    public RealmResults getAllObjectItem() {
        RealmQuery query = mRealm.where(User.class);
        return query.findAll();
    }
}

