package com.springprojects.automobileserver.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "manufacturers")
public class ManufacturerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 ,.'-]+$", message = "Name was entered incorrectly")
    private String name;

    @Column(name = "country")
    @NotBlank(message = "Country name cannot be empty")
    @Pattern(regexp = "^[a-zA-Z '-]+$", message = "Country name was entered incorrectly")
    private String country;

    @Column(name = "founder")
    @NotBlank(message = "Founder name cannot be empty")
    @Pattern(regexp = "^[a-zA-Z '-]+$", message = "Founder name was entered incorrectly")
    private String founder;

    @Column(name = "foundation_year")
    @Min(value = 1900, message = "The year of foundation cannot be less than 1800")
    @Max(value = 2023, message = "The year of foundation cannot be greater than the current")
    private int foundationYear;

    @Column(name = "specialization")
    @NotBlank(message = "Specialization cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 ,.'-]+$", message = "Specialization was entered incorrectly")
    private String specialization;

    @Column(name = "technologies")
    @NotBlank(message = "Technologies cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 ,.'-]+$", message = "Technologies was entered incorrectly")
    private String technologies;

    @Column(name = "number_of_staff")
    @Min(value = 1, message = "Number of staff must be at least 1")
    @Max(value = 1000000, message = "Number of staff cannot be greater than 1,000,000")
    private int numberOfStuff;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CarEntity> carEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<CarEntity> getCarModels() {
        return carEntities;
    }

    public void setCarModels(List<CarEntity> carEntities) {
        this.carEntities = carEntities;
    }

    public void assign(ManufacturerEntity other) {
        this.name = other.name;
        this.country = other.country;
        this.founder = other.founder;
        this.foundationYear = other.foundationYear;
        this.specialization = other.specialization;
        this.technologies = other.technologies;
        this.numberOfStuff = other.numberOfStuff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManufacturerEntity that = (ManufacturerEntity) o;
        return foundationYear == that.foundationYear &&
                numberOfStuff == that.numberOfStuff &&
                Objects.equals(name, that.name) &&
                Objects.equals(country, that.country) &&
                Objects.equals(founder, that.founder) &&
                Objects.equals(specialization, that.specialization) &&
                Objects.equals(technologies, that.technologies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, founder, foundationYear, specialization, technologies, numberOfStuff);
    }

}
