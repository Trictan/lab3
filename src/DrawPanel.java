package src;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    BufferedImage volvoWorkshopImage;

    int imgWidth=100;
    int imgHeight=60;

    int xOffset= (int) imgWidth/2;
    int yOffset= (int) imgHeight/2;

    ArrayList<Drawable> drawableObjects;


    public void addDrawableObject(Drawable drawableObject) {
        drawableObjects.add(drawableObject);
    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        drawableObjects = new ArrayList<Drawable>();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Scania.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image;
        for (Drawable d : this.drawableObjects) {
            image = switch (d.getClass().getSimpleName()) {
                case "Volvo240" -> volvoImage;
                case "Saab95" -> saabImage;
                case "Scania" -> scaniaImage;
                case "Workshop" -> volvoWorkshopImage;
                default -> volvoImage;
            };
            g.drawImage(image, (int) d.getPosition().getX()-xOffset, (int) d.getPosition().getY()-yOffset,null);
        } 
    }
}


