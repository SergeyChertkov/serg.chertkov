import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Clicker {

    public static void main(String[] args) throws InterruptedException, AWTException {
        Random rand = new Random();
        boolean isPrevActive = true;
        Date start = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        System.out.println(format.format(new Date()) + " Activity started");
        Robot bot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int width = (int) b.getX() + 1;
        int height = (int) b.getY() + 1;
        while (Math.random() > -1) {
            a = MouseInfo.getPointerInfo();
            b = a.getLocation();
            int x = (int) b.getX();
            int y = (int) b.getY();
            if (x == width && y == height) {
                width = rand.nextInt((int) screenSize.getWidth());
                height = rand.nextInt((int) screenSize.getHeight());
                if (isPrevActive) {
                    Date finish = new Date();
                    System.out.println("\nActivity time:               " + (finish.getTime() - start.getTime()) / 60000 + "m");
                    System.out.println(format.format(finish) + " Activity finished");
                }
                bot.mouseMove(width, height);
                isPrevActive = false;
            } else {
                if (!isPrevActive) {
                    start = new Date();
                    System.out.println(format.format(new Date()) + " Activity started");
                }
                width = x;
                height = y;
                isPrevActive = true;
            }
            Thread.sleep(150000);
            if (isPrevActive) {
                System.out.print(".");
            }
        }
    }
}
