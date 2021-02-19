package entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

abstract public class BaseEntity extends JPanel {

    private static final String ROOT_PATH = "src/main/resources/";

    protected String entityImage;
    private Image image;

    private int width;
    private int height;

    public BaseEntity(String entityImage, int width, int height){
        super();
        this.entityImage = entityImage;
        this.width = width;
        this.height = height;
    }

    abstract public EntityType getEntityType();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            image = ImageIO.read(new File(ROOT_PATH+entityImage));
            g.drawImage(image, 0, 0, width, height, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
