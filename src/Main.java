package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> whitelist = new ArrayList<>(Arrays.asList("Volvo240"));
        Workshop<Car> myWorkshop = new Workshop<Car>(3, new P2D(300,50), whitelist);

        Observable o = new Observable();
        
        CarModel carModel = new CarModel(o);
        CarController carController = new CarController(carModel);

        /*
        Volvo240 myVolvo = new Volvo240(new Color(0,255,0,0), new P2D(50,30));
        Saab95 mySaab = new Saab95(new Color(0,255,0,0), new P2D(50,130));
        Scania myScania = new Scania(new Color(0,255,0,0), new P2D(50,230));

        carController.addObject(myVolvo);
        carController.addObject(mySaab);
        carController.addObject(myScania);
        */
        carController.addObject(myWorkshop);

        @SuppressWarnings("unused")
        CarView carview = new CarView("CarView 1.0",carModel, carController,o);

    }

    
}
