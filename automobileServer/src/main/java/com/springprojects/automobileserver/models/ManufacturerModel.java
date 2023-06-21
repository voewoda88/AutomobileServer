package com.springprojects.automobileserver.models;

import com.springprojects.automobileserver.entities.CarEntity;
import com.springprojects.automobileserver.entities.ManufacturerEntity;

import java.util.ArrayList;
import java.util.List;

public class ManufacturerModel {
    private String name;

    private String country;

    private String founder;

    private int foundationYear;

    private String specialization;

    private String technologies;

    private int numberOfStuff;

    private List<CarModel> carModels;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public int getNumberOfStuff() {
        return numberOfStuff;
    }

    public void setNumberOfStuff(int numberOfStuff) {
        this.numberOfStuff = numberOfStuff;
    }

    public List<CarModel> getCarModels() {
        return carModels;
    }

    public void setCarModels(List<CarModel> carModels) {
        this.carModels = carModels;
    }

    public void assign(ManufacturerEntity manufacturer) {
        this.name = manufacturer.getName();
        this.country = manufacturer.getCountry();
        this.founder = manufacturer.getFounder();
        this.foundationYear = manufacturer.getFoundationYear();
        this.specialization = manufacturer.getSpecialization();
        this.technologies = manufacturer.getTechnologies();
        this.numberOfStuff = manufacturer.getNumberOfStuff();
        assignList(manufacturer.getCarModels());
    }

    public void assignList(List<CarEntity> carEntityList) {
        this.carModels = new ArrayList<>();
        for (CarEntity carEntity : carEntityList) {
            CarModel temp = new CarModel();
            temp.assign(carEntity);
            this.carModels.add(temp);
        }
    }
}
