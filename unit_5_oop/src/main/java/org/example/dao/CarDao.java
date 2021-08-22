package org.example.dao;

import org.example.entity.Car;

public interface CarDao {

    void createCar(Car car);
    void updateCar(Car car);
    void deleteCar(String id);
    Car getCarById(String id);
    Car[] getAllCars();
}
