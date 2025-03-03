package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        Volvo240 myVolvo = new Volvo240(new Color(0,255,0,0), new P2D(50,30));
        Saab95 mySaab = new Saab95(new Color(0,255,0,0), new P2D(50,130));
        Scania myScania = new Scania(new Color(0,255,0,0), new P2D(50,230));

        ArrayList<String> whitelist = new ArrayList<>(Arrays.asList("Volvo240"));
        cc.myWorkshop = new Workshop<Car>(3, new P2D(300,50), whitelist);

        cc.cars.add(myVolvo);
        cc.cars.add(mySaab);
        cc.cars.add(myScania);
    }
}
