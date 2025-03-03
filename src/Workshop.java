package src;
import java.util.ArrayList;

public class Workshop<T extends Car> implements Drawable {
    private Carrier<T> parent;
    private ArrayList<String> whitelist;

    public Workshop(int capacity, P2D position, ArrayList<String> whitelist) {
        this.parent = new Carrier<>(capacity, position);
        this.whitelist = whitelist;
    }

    public boolean isClose(T car) {
        return parent.isClose(car);
    }

    public void setPosition(double x, double y) {
        parent.setPosition(x, y);
    }

    public P2D getPosition() {
        return parent.getPosition();
    }

    public void loadCar(T car) {
        if (whitelist.contains(car.getModelName())) {
            parent.loadCar(car);
        } else {
            throw new java.lang.Error(car.getModelName() + " is not accepted at this workshop!");
        }
    }

    public T unloadCar(int nr) {
        T unloadedCar = parent.unloadCar(nr-1);
        System.out.println(
        "Model name: " + unloadedCar.getModelName() + "\n" +
        "Engine power: " + unloadedCar.getEnginePower() + "\n" +
        "Nr Doors: " + unloadedCar.getNrDoors() + "\n" +
        "Color :"  + unloadedCar.getColor() + "\n"
        );
        return unloadedCar;
    }

}
