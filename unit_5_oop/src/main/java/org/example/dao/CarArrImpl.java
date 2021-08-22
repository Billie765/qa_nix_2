package org.example.dao;

import org.example.entity.Car;
import org.example.db.CarDB;

public class CarArrImpl implements CarDao{

    private CarDB db = new CarDB();

    public void createCar(Car car) {
        db.createCar(car);
    }

    public void updateCar(Car car) {
        db.updateCar(car);
    }

    public void deleteCar(String id) {
        db.deleteCar(id);
    }

    public Car getCarById(String id) {
        return db.getCarById(id);
    }

    public Car[] getAllCars() {
        return db.getAllCars();
    }
}
