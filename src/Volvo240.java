package src;
import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    public Volvo240(Color color, P2D startposition){
        super(4, 100, 0, color, "Volvo240", startposition);
    }
    
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
