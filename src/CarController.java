package src;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;

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

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        Volvo240 myVolvo = new Volvo240(new Color(0,255,0,0), new P2D(0,0));
        Saab95 mySaab = new Saab95(new Color(0,255,0,0), new P2D(0,100));
        Scania myScania = new Scania(new Color(0,255,0,0), new P2D(0,200));
        ArrayList<String> whitelist = new ArrayList<>(Arrays.asList("Volvo240"));
        cc.myWorkshop = new Workshop<Car>(3, new P2D(350,98), whitelist);
        cc.cars.add(myVolvo);
        cc.cars.add(mySaab);
        cc.cars.add(myScania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (var i = 0; i < cars.size(); i++) {
                Car currentCar = cars.get(i);
                currentCar.move();
                P2D p = currentCar.getPosition();
                if (p.getX()<0) {currentCar.stopEngine(); currentCar.setPosition(0, p.getY()); for (var k = 0; k<36; k++) {currentCar.turnLeft();}; currentCar.startEngine();}
                if (p.getX()>700) {currentCar.stopEngine(); currentCar.setPosition(700, p.getY()); for (var k = 0; k<36; k++) {currentCar.turnRight();}; currentCar.startEngine();}
                if (p.getX() > 200 && p.getX() < 501) myWorkshop.loadCar(cars.get(i));
                frame.drawPanel.moveit(p, i);
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
        Saab95 mySaab = (Saab95) cars.get(1);
        mySaab.setTurboOn();
    }

    void turboOffButton() {
        Saab95 mySaab = (Saab95) cars.get(1);
        mySaab.setTurboOff();
    }
    // SCANIA
    void liftBedButton() {
        Scania myScania = (Scania) cars.get(2);
        myScania.increaseIncline();
    }

    void lowerBedButton() {
        Scania myScania = (Scania) cars.get(2);
        myScania.decreaseIncline();
    }

}
