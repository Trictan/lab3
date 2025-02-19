package src;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    int imgWidth=100;
    int imgHeight=60;

    int xOffset= (int) imgWidth/2;
    int yOffset= (int) imgHeight/2;

    Point[] carPoints = {new Point(), new Point(), new Point()};

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,50);

    // TODO: Make this general for all cars
    void moveit(P2D p, int i){
        carPoints[i] = new Point((int) p.getX(), (int) p.getY());
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
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
        g.drawImage(volvoImage, carPoints[0].x-xOffset, carPoints[0].y-yOffset, null);
        g.drawImage(saabImage, carPoints[1].x-xOffset, carPoints[1].y-yOffset, null);
        g.drawImage(scaniaImage, carPoints[2].x-xOffset, carPoints[2].y-yOffset, null); // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x-49, volvoWorkshopPoint.y-48, null);
    }
}

