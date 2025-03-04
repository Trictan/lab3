package src;
import java.awt.*;

public abstract class Car implements Movable, Drawable{
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private int dirAngle; // The current direction of the car
    private P2D position;
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private boolean towed;

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, P2D startposition) {
        this.nrDoors=nrDoors;
        this.enginePower=enginePower;
        this.currentSpeed=0;
        this.dirAngle = 0;
        this.position = startposition;
        this.color=color;
        this.modelName=modelName;
    }

    // CARRY

    public boolean isCarriable() {
        return true;
    }

    public boolean isCarried() {
        return towed;
    }

    public void setCarried() {
        towed = true;
    }

    public void setNotCarried() {
        towed = false;
    }

    protected void follow(Carrier<? extends Car> carrier) { //fix
        this.setPosition(carrier.getPosition().getX(), carrier.getPosition().getY());
    }

    //

    public void turnAround() {
        this.stopEngine();
        for (var k = 0; k<36; k++) {this.turnLeft();}
        this.startEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public String getModelName(){
        return modelName;
    }

    public P2D getPosition(){
        return position;
    }

    public int getDirection() {
        return dirAngle;
    }

    public Color getColor(){
        return color;
    }

    
    @SuppressWarnings("unused")
    private void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
        if (!isCarried()) {currentSpeed = 0.1;}
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }
    
    public double speedFactor(){
        return enginePower * 0.01;
    }

    private void incrementSpeed(double amount){
        if (!isCarried()) {
	        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        }
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void setPosition(double x, double y) {
        position.setLocation(x,y);
    }

    private void setDirection(int dir) {
        dirAngle = dir;
    }

    public void move() {
        setPosition(getPosition().getX() + (getCurrentSpeed() * Math.cos(getDirection() * (Math.PI/180))), 
                    getPosition().getY() + (getCurrentSpeed() * Math.sin(getDirection() * (Math.PI/180))));
    }

    public void turnLeft() {
        setDirection(getDirection() + 5);
    }

    public void turnRight() {
        setDirection(getDirection() - 5);
    }

    // Increase currentspeed
    public void gas(double amount){
        if (amount < 0 || amount > 1) {
            System.out.println("Invalid input: gas only accepts values in the interval [0,1].");
        } else {
            if (!isCarried()) {incrementSpeed(amount);}
        }
    }

    // Decrease currentspeed
    public void brake(double amount){
        if (amount < 0 || amount > 1) {
            System.out.println("Invalid input: brake only accepts values in the interval [0,1].");
        } else {
            decrementSpeed(amount);
        }
    }

}

