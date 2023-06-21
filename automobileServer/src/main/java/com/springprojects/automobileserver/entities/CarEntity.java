package com.springprojects.automobileserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
@Table(name = "car_models")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Model name cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 '-]+$", message = "Model name was entered incorrectly")
    private String modelName;

    @Column(name = "body_type")
    @NotBlank(message = "Body type cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 -]+$", message = "Body type was entered incorrectly")
    private String bodyType;

    @Column(name = "year")
    @Min(value = 1900, message = "The year of model cannot be less than 1800")
    @Max(value = 2023, message = "The year of model cannot be greater than the current")
    private int year;

    @Column(name = "engine")
    @NotBlank(message = "Body type cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 -]+$", message = "Body type was entered incorrectly")
    private String engine;

    @Column(name = "color")
    @NotBlank(message = "Body type cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 -]+$", message = "Body type was entered incorrectly")
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    @JsonBackReference
    @NotNull
    private ManufacturerEntity manufacturer;

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

    public ManufacturerEntity getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerEntity manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return year == carEntity.year &&
                Objects.equals(modelName, carEntity.modelName) &&
                Objects.equals(bodyType, carEntity.bodyType) &&
                Objects.equals(engine, carEntity.engine) &&
                Objects.equals(color, carEntity.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, bodyType, year, engine, color);
    }

    public void assign(CarEntity other) {
        this.modelName = other.modelName;
        this.bodyType = other.bodyType;
        this.year = other.year;
        this.engine = other.engine;
        this.color = other.color;
    }

}
