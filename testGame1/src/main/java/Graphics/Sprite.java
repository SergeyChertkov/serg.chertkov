package Graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by sergey on 30.05.2016.
 */
public class Sprite {
    private Image image; //изображение

    public Sprite(String image) {
        BufferedImage sourceImage = null;
        try {
            URL url = this.getClass().getClassLoader().getResource(image);
            sourceImage = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.image = Toolkit.getDefaultToolkit().createImage(sourceImage.getSource());
    }

    public void draw(Graphics g,int x,int y) { //рисуем картинку
        g.drawImage(image,x,y,null);
    }
}
