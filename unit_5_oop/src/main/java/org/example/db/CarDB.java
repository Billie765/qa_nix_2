package org.example.db;

import org.example.entity.Car;


import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class CarDB {

    private Car[] cars = new Car[10];

    public void createCar(Car car) {
        car.setId(generateId());
        boolean freeSpace = false;
        for (int i=0; i < cars.length; i ++) {
            if (cars[i] == null) {
                cars[i] = car;
                freeSpace = true;
                break;
            }
        }
        if (!freeSpace) {
            Car[] newCars = new Car[cars.length+5];
            for (int i=0;i<cars.length;i++) {
                newCars[i] = cars[i];
            }
            newCars[cars.length] = car;
            cars = newCars;
        }
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (Car car : cars) {
            if (car!=null && car.getId().equals(id)){
                return generateId();
            }
        }
        return id;
    }

    private int findPosition(String id) {
        int position = -1;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i]!= null && cars[i].getId().equals(id)) {
                position = i;
                break;
            }
        }
        return position;
    }

    public Car[] getAllCars() {
        return cars;
    }

    public Car getCarById(String id) {
        int position = findPosition(id);
        return cars[position];
    }

    public void updateCar(Car car) {
        int position = findPosition(car.getId());
        cars[position].setColor(car.getColor());
        cars[position].setModel(car.getModel());
        cars[position].setYear(car.getYear());
    }

    public void deleteCar(String id) {
        int position = findPosition(id);
        if (position == cars.length - 1) {
            cars[position] = null;
        } else {
            for (int i = position; i < cars.length - 2; i++) {
                cars[i] = cars[i + 1];
            }
        }
        if (cars.length > 1) {
            Car[] newCars = new Car[cars.length - 1];
            for (int i = 0; i < newCars.length; i++) {
                newCars[i] = cars[i];
            }
            cars = newCars;
        }
    }
}
