import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Clicker {

    public static void main(String[] args) throws InterruptedException, AWTException {
        Random rand = new Random();
        int allActivityTime = 0;
        int currActivityTime;
        int dot = 0;
        boolean isPrevActive = true;
        Date start = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        System.out.println("\n╔══════════════════════════╗");
        System.out.println("║" + format.format(new Date()) + " Activity started ║");
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
                    while (dot < 26) {
                        System.out.print(" ");
                        dot++;
                    }
                    System.out.print("║");
                    Date finish = new Date();
                    currActivityTime = (int) ((finish.getTime() - start.getTime()) / 60000);
                    allActivityTime += currActivityTime;
                    System.out.println("\n║" + format.format(finish) + " Activity paused  ║");
                    System.out.printf("║Activity time:     %5dm ║%n", currActivityTime);
                    System.out.println("╟──────────────────────────╢");
                    System.out.printf("║            TOTAL: %5.2fh ║%n", ((double) allActivityTime / 60));
                    System.out.println("╚══════════════════════════╝");
                }
                bot.mouseMove(width, height);
                isPrevActive = false;
            } else {
                if (!isPrevActive) {
                    start = new Date();
                    System.out.println("\n╔══════════════════════════╗");
                    System.out.println("║" + format.format(new Date()) + " Activity started ║");
                    dot = 0;
                }
                width = x;
                height = y;
                isPrevActive = true;
            }
            Thread.sleep(150);
            if (isPrevActive) {
                dot++;
                if (dot > 26) {
                    System.out.print("║\n");
                    dot = 1;
                }
                if (dot == 1) {
                    System.out.print("║");
                }
                System.out.print("•");
            }
        }
    }
}
