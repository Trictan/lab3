package src;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class CarModel {
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Workshop<Car>> workshops = new ArrayList<>();

    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    private Observable observer;

    public CarModel(Observable o) {
        this.observer = o;
        this.timer.start();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Workshop<Car>> getWorkshops() {
        return workshops;
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (cars.size()>0)
            for (Car currentCar : cars) {
                currentCar.move();
                if (currentCar.getPosition().getX()<50) {currentCar.turnAround(); currentCar.setPosition(50, currentCar.getPosition().getY());}
                if (currentCar.getPosition().getX()>750) {currentCar.turnAround(); currentCar.setPosition(750, currentCar.getPosition().getY());}
                for (Workshop<Car> workshop : workshops) {
                    if (workshop.isClose(currentCar)) {workshop.loadCar(currentCar);}
                }
            }
            observer.notifyObservers();
        }
    }

    // add objects

    public void addObject(Car car) {
        cars.add(car);
    }

    public void addObject(Workshop<Car> workshop) {
        workshops.add(workshop);
    }

    // add/remove cars
    public void addCar() {
        if (cars.size()>9) {return;}
        Car newCar;
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);
        newCar = switch (randomNum) {
            case 0 -> new Volvo240(new Color(0,0,0), new P2D(50, cars.size()*60+50));
            case 1 -> new Saab95(new Color(0,0,0), new P2D(50, cars.size()*60+50));
            case 2 -> new Scania(new Color(0,0,0), new P2D(50, cars.size()*60+50));
            default -> new Volvo240(new Color(0,0,0), new P2D(50, cars.size()*60+50));
        };
        addObject(newCar);
    }

    public void removeCar() {
        if (cars.isEmpty()) {return;}
        cars.remove(0);
    }

    // CAR
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.brake(gas);
        }
    }

    public void stopEngine() {
        for (Car car : cars
                ) {
            car.stopEngine();
        }
    }

    public void startEngine() {
        for (Car car : cars
                ) {
            car.startEngine();
        }
    }

    // SAAB
    public void turboOnButton() {
        for (Car car: cars) {
            if (car instanceof Turbo) {
                ((Turbo) car).setTurboOn();
            }
        }
    }

    public void turboOffButton() {
        for (Car car: cars) {
            if (car instanceof Turbo) {
                ((Turbo) car).setTurboOff();
            }
        }
    }
    // SCANIA
    public void liftBedButton() {
        for (Car car:cars) {
        if (car instanceof Truck) {
            ((Truck) car).increaseIncline();
            }
        }
    }

    public void lowerBedButton() {
        for (Car car:cars) {
            if (car instanceof Truck) {
                ((Truck) car).decreaseIncline();
            }
        }
    }

    
}
