package com.task.three.model.service;

import com.task.three.model.entity.Car;
import com.task.three.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


public class CarService {


    public CarService() {
    }

    public EntityManager em = Persistence.createEntityManagerFactory("CARPARK").createEntityManager();
    public Car addCar(Car car){
        em.getTransaction().begin();
        Car carFromDB = em.merge(car);
        em.getTransaction().commit();
        return carFromDB;
    }

    public void deleteCar(long id){
        em.getTransaction().begin();
        em.remove(getCar(id));
        em.getTransaction().commit();
    }

    public Car getCar(long id){
        return em.find(Car.class, id);
    }

    public void updateCar(Car car){
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
    }

    public List<Car> getAll(){
        TypedQuery<Car> namedQuery = em.createNamedQuery("Car.getAll", Car.class);
        return namedQuery.getResultList();
    }
    public List<Car> findAllCarsByName(String name) {
        String queryString = "SELECT c FROM Car c WHERE LOWER(c.name) = :name";
        Query query = em.createQuery(queryString);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
