package src;
import java.awt.*;


public class CarCarrier extends Truck {
    private Carrier<Car> parent;

    public CarCarrier(Color color, String modelname, int capacity, P2D startposition) {
        super(2, 100, 0, color, modelname, startposition);
        this.parent = new Carrier<Car>(capacity, startposition);
        setIncline(getMaxIncline());
    }

    public void getLoad() {
        parent.getLoad();
    }

    @Override
    public void gas(double amount) {
        if (getIncline() == getMaxIncline()) {
            super.gas(amount);
        }
    }

    @Override
    public void increaseIncline() {
        setIncline(getMaxIncline());   // 1
    }

    @Override
    public void decreaseIncline() {
        if (getCurrentSpeed() == 0) {
            setIncline(0);  // 0 (can tow)
        }
    }

    @Override
    public void move() {
        super.move();
        parent.setPosition(getPosition().getX(), getPosition().getY());
    }


    public boolean isClose(Car car) {
        return parent.isClose(car);
    }

    public void loadCar(Car car) {
        if (getIncline() == 0) {
            parent.loadCar(car);
        }
    }

    public void unloadCar() {
        if (getIncline() == 0) {
            parent.unloadCar(parent.getCurrentCapacity()-1);
        }
    }


}
