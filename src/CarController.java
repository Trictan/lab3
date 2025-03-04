package src;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    Workshop<Car> myWorkshop;
    

    //methods:
    public CarController() {
        this.frame = new CarView("CarSim 1.0", this);
    }

    public void startTimer() {
        this.timer.start();
    }


    public void addObject(Car car) {
        cars.add(car);
        frame.drawPanel.addDrawableObject(car);
    }

    public void addObject(Workshop<Car> workshop) {
        myWorkshop = workshop;
        this.frame.drawPanel.addDrawableObject(workshop);
    }

    public void removeCar(int index) {
        cars.remove(index-1);
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (cars.size()>0)
            for (Car currentCar : cars) {
                currentCar.move();
                if (currentCar.getPosition().getX()<50) {currentCar.turnAround();; currentCar.setPosition(50, currentCar.getPosition().getY());}
                if (currentCar.getPosition().getX()>750) {currentCar.turnAround(); currentCar.setPosition(750, currentCar.getPosition().getY());}
                if (myWorkshop.isClose(currentCar)) {myWorkshop.loadCar(currentCar);}
            }
            frame.drawPanel.repaint();
        }
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
