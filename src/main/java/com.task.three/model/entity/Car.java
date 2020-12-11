package com.task.three.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "car")
@NamedQuery(name = "Car.getAll", query = "SELECT c from Car c")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insuranceValue")
    private int insuranceValue;

    public Car(long id, String name, int price, int insuranceValue) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.insuranceValue = insuranceValue;
    }

    public Car(String name, int price, int insuranceValue) {
        this.name = name;
        this.price = price;
        this.insuranceValue = insuranceValue;
    }

    public Car() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInsuranceValue() {
        return insuranceValue;
    }

    public void setInsuranceValue(int insuranceValue) {
        this.insuranceValue = insuranceValue;
    }
}
