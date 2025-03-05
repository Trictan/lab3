package src;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ticker {

    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    public Ticker() {
        this.timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("balle");
        }
    }

}
