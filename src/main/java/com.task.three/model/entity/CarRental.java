package com.task.three.model.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table( name="car_rental",
        uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
//@SecondaryTables({
//        @SecondaryTable(name="user"), @SecondaryTable(name="car")
//})
@NamedQuery(name = "CarRental.getAll", query = "SELECT cr from CarRental cr")
public class CarRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @NotNull
    @Column(name = "startDate")
    private LocalDate startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "daysAmount")
    private int daysAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @JoinColumn(name = "car_id", referencedColumnName = "id",  insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Car car;
    @JoinColumn(name = "client_id", referencedColumnName = "id",  insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User client;

    @Column(name = "car_id", nullable = false)
    private int carId;
    @Column(name = "client_id", nullable = false)
    private int clientId;

    public CarRental() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDaysAmount() {
        return daysAmount;
    }

    public void setDaysAmount(int daysAmount) {
        this.daysAmount = daysAmount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public static class Builder{
        CarRental carRental = new CarRental();

        public Builder id(int id){
            carRental.id = id;
            return this;
        }
        public Builder startDate(LocalDate startDate){
            carRental.startDate = startDate;
            return this;
        }
        public Builder daysAmount(int daysAmount){
            carRental.daysAmount = daysAmount;
            return this;
        }
        public Builder price(int price){
            carRental.price = price;
            return this;
        }
        public Builder clientId(int clientId){
            carRental.clientId = clientId;
            return this;
        }
        public Builder carId(int carId){
            carRental.carId = carId;
            return this;
        }
        public CarRental build(){
            return carRental;
        }
    }
}
