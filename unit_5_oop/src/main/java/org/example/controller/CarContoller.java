package org.example.controller;

import org.example.entity.Car;
import org.example.service.CarService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarContoller {

    private CarService carService = new CarService();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create car, please enter 1");
        System.out.println("if you want update car, please enter 2");
        System.out.println("if you want delete car, please enter 3");
        System.out.println("if you want getCarByID, please enter 4");
        System.out.println("if you want getAllCars, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" : create(reader); break;
            case "2" : update(reader); break;
            case "3" : delete(reader); break;
            case "4" : findById(reader); break;
            case "5" : findAll(reader); break;
            case "0" : System.exit(0);
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        try {
            System.out.println("Please, enter car model");
            String model = reader.readLine();
            System.out.println("Please, enter car year");
            String ageString = reader.readLine();
            System.out.println("Please, enter car color");
            String color = reader.readLine();
            int year = Integer.parseInt(ageString);
            Car car = new Car();
            car.setYear(year);
            car.setModel(model);
            car.setColor(color);
            carService.createCar(car);
            System.out.println("----------------------------------------");
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            System.out.println("Please, enter car model");
            String model = reader.readLine();
            System.out.println("Please, enter car year");
            String ageString = reader.readLine();
            System.out.println("Please, enter car color");
            String color = reader.readLine();
            int year = Integer.parseInt(ageString);
            Car car = new Car();
            car.setId(id);
            car.setYear(year);
            car.setModel(model);
            car.setColor(color);
            carService.updateCar(car);
            System.out.println("----------------------------------------");
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            carService.deleteCar(id);
            System.out.println("----------------------------------------");
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Car car = carService.getCarById(id);
            System.out.println("car = " + car);
            System.out.println("----------------------------------------");
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        Car[] cars = carService.getAllCars();
        for (Car car : cars) {
            System.out.println("car = " + car);
        }
        System.out.println("----------------------------------------");
    }
}
