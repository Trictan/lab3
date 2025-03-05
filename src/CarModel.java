package src;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CarModel {
    ArrayList<Car> cars = new ArrayList<>();
    Workshop<Car> myWorkshop;

    private final int delay = 50;


    public CarModel() {
        this.timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (cars.size()>0)
            for (Car currentCar : cars) {
                currentCar.move();
                if (currentCar.getPosition().getX()<50) {currentCar.turnAround();; currentCar.setPosition(50, currentCar.getPosition().getY());}
                if (currentCar.getPosition().getX()>750) {currentCar.turnAround(); currentCar.setPosition(750, currentCar.getPosition().getY());}
                if (myWorkshop.isClose(currentCar)) {myWorkshop.loadCar(currentCar);}
            }
        }
    }


    // add objects

    public void addObject(Car car) {
        cars.add(car);
        //frame.drawPanel.addDrawableObject(car);
    }

    public void addObject(Workshop<Car> workshop) {
        myWorkshop = workshop;
        //this.frame.drawPanel.addDrawableObject(workshop);
    }

    // CAR
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.brake(gas);
        }
    }

    void stopEngine() {
        for (Car car : cars
                ) {
            car.stopEngine();
        }
    }

    void startEngine() {
        for (Car car : cars
                ) {
            car.startEngine();
        }
    }

    // SAAB
    void turboOnButton() {
        for (Car car: cars) {
            if (car instanceof Turbo) {
                ((Turbo) car).setTurboOn();
            }
        }
    }

    void turboOffButton() {
        for (Car car: cars) {
            if (car instanceof Turbo) {
                ((Turbo) car).setTurboOff();
            }
        }
    }
    // SCANIA
    void liftBedButton() {
        for (Car car:cars) {
        if (car instanceof Truck) {
            ((Truck) car).increaseIncline();
            }
        }
    }

    void lowerBedButton() {
        for (Car car:cars) {
            if (car instanceof Truck) {
                ((Truck) car).decreaseIncline();
            }
        }
    }

    
}
