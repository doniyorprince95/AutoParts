package com.mobapplic.autoparts.model.user;


import com.mobapplic.autoparts.model.car.Car;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {

    @PrimaryKey
    private int mId;
    private String mUserName;
    private String mPassword;
    private Car mCar;

    public User() {
    }

    public User(int id, String userName, String password, Car car) {
        mId = id;
        mUserName = userName;
        mPassword = password;
        mCar = car;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public Car getCar() {
        return mCar;
    }

    public void setCar(Car car) {
        mCar = car;
    }
}
