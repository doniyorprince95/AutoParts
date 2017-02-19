package com.mobapplic.autoparts.model.repository.user;


import com.mobapplic.autoparts.model.entity.user.User;
import com.mobapplic.autoparts.model.repository.Repository;

import java.util.List;

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
        User u = new User();
        u.in(user);
        mRealm.copyToRealmOrUpdate(u);
    }

    @Override
    public void deleteObjectByName(String userName) {
        mRealm.beginTransaction();
        User user = mRealm.where(User.class).equalTo("userName", userName).findFirst();
        user.deleteFromRealm();
        mRealm.commitTransaction();
    }

    @Override
    public void deleteObjectByPosition(int position) {
        RealmQuery query = mRealm.where(User.class);
        RealmResults results = query.findAll();
        results.deleteFromRealm(position);
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

    @Override
    public void update(List<User> users) {
        for (User user : users) {
            addObject(user);
        }
    }
}

