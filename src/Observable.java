package src;
import java.util.ArrayList;

public class Observable {
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
                o.update();
        }
    }
}
