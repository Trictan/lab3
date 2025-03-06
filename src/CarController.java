package src;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {

    // Model of MVC pattern
    private CarModel model;

    // Signal model
    public CarController(CarModel model) {
        this.model = model;
    }

    public void addCar() {
        model.addCar();
    }

    public void removeCar() {
        model.removeCar();
    }


    public void gas(int amount) {
        model.gas(amount);
    }

    public void brake(int amount) {
        model.brake(amount);
    }

    public void stopEngine() {
        model.stopEngine();
    }

    public void startEngine() {
        model.startEngine();
    }

    // SAAB
    public void turboOnButton() {
        model.turboOnButton();
    }

    public void turboOffButton() {
        model.turboOffButton();
    }
    // SCANIA
    public void liftBedButton() {
        model.liftBedButton();
    }

    public void lowerBedButton() {
        model.lowerBedButton();
    }
    
}