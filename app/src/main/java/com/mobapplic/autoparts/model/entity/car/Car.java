package com.mobapplic.autoparts.model.entity.car;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Car extends RealmObject {
    @PrimaryKey
    private String id;
    private String mark;
    private String model;
    private long date;
    private float engineCapacity;
    private String body;
    private String VIN;

    public Car() {
    }

    public Car(String id, String mark, String model) {
        this.id = id;
        this.mark = mark;
        this.model = model;
    }

    public Car(String id, String mark, String model, long date, float engineCapacity, CarBody body, String VIN) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.date = date;
        this.engineCapacity = engineCapacity;
        this.body = body.toString();
        this.VIN = VIN;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public float getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(float engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public CarBody getBody() {
        return CarBody.valueOf(body);
    }

    public void setBody(CarBody body) {
        this.body = body.toString();
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public void in(Car car) {
        this.id = car.getId();
        this.mark = car.getMark();
        this.model = car.getModel();
        this.date = car.getDate();
        this.engineCapacity = car.getEngineCapacity();
        this.body = car.getBody().toString();
        this.VIN = car.getVIN();
    }

    public Car out() {
        Car car = new Car();
        car.setId(this.getId());
        car.setMark(this.getMark());
        car.setModel(this.getModel());
        car.setDate(this.getDate());
        car.setEngineCapacity(this.getEngineCapacity());
        car.setBody(this.getBody());
        car.setVIN(this.getVIN());
        return car;
    }
}
