package src;
import java.awt.*;

public abstract class Truck extends Car {

    private int incline;
    private int maxIncline;

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, P2D startposition) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, startposition);
        this.incline = 0;
        this.maxIncline = 70;
    }

    @Override
    public boolean isCarriable() {
        return false;
    }

    @Override
    public void startEngine() {
        if (getIncline() == 0) {
            super.startEngine();
        }
    }

    @Override
    public void gas(double amount) {
        if (getIncline() == 0) {
            super.gas(amount);
        }
    }

    public void increaseIncline() {
        if (getCurrentSpeed() == 0) {
            incline = Math.min(incline+5,maxIncline);
        }
    }

    public void decreaseIncline() {
        incline = Math.max(incline-5,0);
    }

    public int getIncline() {
        return incline;
    }

    public int getMaxIncline() {
        return maxIncline;
    }

    protected void setIncline(int newIncline) {
        incline = newIncline;
    }
}
