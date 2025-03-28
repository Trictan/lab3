package src;
import java.util.ArrayList;

public class Carrier<T extends Car> {
    private int capacity;
    private ArrayList<T> load;
    private P2D position;


    public Carrier(int capacity, P2D position) {
        this.capacity = capacity;
        this.position = position;
        this.load = new ArrayList<T>();
    }


    public int getCurrentCapacity() {
        return load.size();
    }


    public void getLoad() {
        for (var i = 0; i < load.size(); i++) {
            System.out.println(load.get(i));
        }
    }


    public boolean isClose(T car) {
        double x_dif = car.getPosition().getX() - getPosition().getX();
        double y_dif = car.getPosition().getY() - getPosition().getY();
        double r = Math.sqrt(Math.pow(x_dif, 2)+Math.pow(y_dif, 2));
        if (r<80) {return true;} else {
            return false;
        }
    }

    public void setPosition(double x, double y) {
        position.setLocation(x, y);
        for (int i = 0; i < load.size(); i++) {
            load.get(i).follow(this);
        }
        
    }

    public P2D getPosition() {
        return position;
    }

    public void loadCar(T car) {
        if (load.size() < capacity) { // has space
            if (car.isCarriable() && !car.isCarried()) { // car is ok to pickup
                if (isClose(car)) {
                    System.out.println("Carrying " + car.getModelName());
                    car.stopEngine();
                    load.add(car);
                    car.setCarried();
                }
            }
        }
    }

    public T unloadCar(int index) {
        if (load.size() > 0) {
            if (index >= 0 && index < load.size()) {
                T outputCar = load.get(index);
                outputCar.setNotCarried();
                load.remove(index);
                return outputCar;
            } else {throw new java.lang.Error("Could not find car. Index out of range.");}
        } else {throw new java.lang.Error("There are no cars to unload.");}
    }

}
