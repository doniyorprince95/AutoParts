package com.mobapplic.autoparts.model.entity.user;


import com.mobapplic.autoparts.model.entity.car.Car;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {

    @PrimaryKey
    private String id;
    private String userName;
    private String password;
    private Car car;

    public User() {
    }

    public User(String id, String userName, String password, Car car) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.car = car;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
