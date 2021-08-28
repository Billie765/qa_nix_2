package org.example.service;

import org.example.entity.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlanetReporter {

    public void start() {
        PlanetCalcImpl planetCalc = new PlanetCalcImpl();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Choose your planet to calculate acceleration");
            System.out.println("Press 1 to calculate Mercury");
            System.out.println("Press 2 to calculate Venus");
            System.out.println("Press 3 to calculate Earth");
            System.out.println("Press 4 to calculate Mars");
            System.out.println("Press 5 to calculate Jupyter");
            System.out.println("Press 6 to calculate Saturn");
            System.out.println("Press 7 to calculate Uranus");
            System.out.println("Press 8 to calculate Neptune");
            System.out.println("Press 0 to exit the application");
            try {
                String input = reader.readLine();

                switch (input) {
                    case "1":
                        BasePlanet mercury = new Mercury();
                        System.out.println(planetCalc.calculateAcceleration(mercury.getDiameter(), mercury.getWeight()));
                        break;
                    case "2":
                        BasePlanet venus = new Venus();
                        System.out.println(planetCalc.calculateAcceleration(venus.getDiameter(), venus.getWeight()));
                        break;
                    case "3":
                        BasePlanet earth = new Earth();
                        System.out.println(planetCalc.calculateAcceleration(earth.getDiameter(), earth.getWeight()));
                        break;
                    case "4":
                        BasePlanet mars = new Mars();
                        System.out.println(planetCalc.calculateAcceleration(mars.getDiameter(), mars.getWeight()));
                        break;
                    case "5":
                        BasePlanet jupyter = new Jupyter();
                        System.out.println(planetCalc.calculateAcceleration(jupyter.getDiameter(), jupyter.getWeight()));
                        break;
                    case "6":
                        BasePlanet saturn = new Saturn();
                        System.out.println(planetCalc.calculateAcceleration(saturn.getDiameter(), saturn.getWeight()));
                        break;
                    case "7":
                        BasePlanet uranus = new Uranus();
                        System.out.println(planetCalc.calculateAcceleration(uranus.getDiameter(), uranus.getWeight()));
                        break;
                    case "8":
                        BasePlanet neptune = new Neptune();
                        System.out.println(planetCalc.calculateAcceleration(neptune.getDiameter(), neptune.getWeight()));
                        break;
                    case "0":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Incorrect input. Enter number from 0 to 8");
                }
                System.out.println();
                System.out.println("---------------------------------------");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
