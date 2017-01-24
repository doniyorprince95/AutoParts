package com.mobapplic.autoparts.model.car;

import io.realm.RealmObject;

public class Car extends RealmObject {

    private long mId;
    private String mMark;
    private String mModel;
    private long mDate;
    private float mEngineCapacity;
    private String mBody;
    private String mVIN;

    public Car() {
    }

    public Car(long id, String mark, String model) {
        mId = id;
        mMark = mark;
        mModel = model;
    }

    public Car(long id, String mark, String model, long date, float engineCapacity, CarBody body, String VIN) {
        mId = id;
        mMark = mark;
        mModel = model;
        mDate = date;
        mEngineCapacity = engineCapacity;
        mBody = body.toString();
        mVIN = VIN;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getMark() {
        return mMark;
    }

    public void setMark(String mark) {
        mMark = mark;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }

    public long getDate() {
        return mDate;
    }

    public void setDate(long date) {
        mDate = date;
    }

    public float getEngineCapacity() {
        return mEngineCapacity;
    }

    public void setEngineCapacity(float engineCapacity) {
        mEngineCapacity = engineCapacity;
    }

    public CarBody getBody() {
        return CarBody.valueOf(mBody);
    }

    public void setBody(CarBody body) {
        mBody = body.toString();
    }

    public String getVIN() {
        return mVIN;
    }

    public void setVIN(String VIN) {
        mVIN = VIN;
    }
}
