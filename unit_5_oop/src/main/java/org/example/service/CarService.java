package org.example.service;

import org.example.dao.CarArrImpl;
import org.example.dao.CarDao;
import org.example.entity.Car;

public class CarService {

    private CarDao dao = new CarArrImpl();

    public void createCar(Car car) {
        dao.createCar(car);
    }

    public void updateCar(Car car) {
        dao.updateCar(car);
    }

    public void deleteCar(String id) {
        dao.deleteCar(id);
    }

    public Car getCarById(String id) {
        return dao.getCarById(id);
    }

    public Car[] getAllCars() {
        return dao.getAllCars();
    }
}
