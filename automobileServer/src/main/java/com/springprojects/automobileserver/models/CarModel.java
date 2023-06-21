package com.springprojects.automobileserver.models;

import com.springprojects.automobileserver.entities.CarEntity;

public class CarModel {
    private String modelName;
    private String bodyType;
    private int year;
    private String engine;
    private String color;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void assign(CarEntity car) {
        this.modelName = car.getModelName();
        this.bodyType = car.getBodyType();
        this.year = car.getYear();
        this.engine = car.getEngine();
        this.color = car.getColor();
    }
}
