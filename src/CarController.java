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



    // Model of MVC pattern
    CarModel model;

    //methods:
    public CarController(CarModel model) {
        this.model = model;
    }
    
    public void addObject(Car car) {
        model.addObject(car);
    }

    public void addObject(Workshop<Car> workshop) {
        model.addObject(workshop);
    }


    void gas(int amount) {
        model.gas(amount);
    }

    void brake(int amount) {
        model.brake(amount);
    }

    void stopEngine() {
        model.stopEngine();
    }

    void startEngine() {
        model.startEngine();
    }

    // SAAB
    void turboOnButton() {
        model.turboOnButton();
    }

    void turboOffButton() {
        model.turboOffButton();
    }
    // SCANIA
    void liftBedButton() {
        model.liftBedButton();
    }

    void lowerBedButton() {
        model.lowerBedButton();
    }
    
}
