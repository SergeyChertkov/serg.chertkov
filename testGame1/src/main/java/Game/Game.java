package Game;

import Fauna.Animals;
import Flora.World;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by sergey on 28.05.2016.
 */
public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;
    private boolean running = false;
    public static int WIDTH = 1260; //ширина 252
    public static int HEIGHT = 940; //высота 188
    public static String NAME = "Evolution v.1.2"; //заголовок окна
    public static int step = 5;
    public static int turn;

    public void run() {
        long lastTime = System.currentTimeMillis();
        long delta;

        init();

        while(running) {
            delta = System.currentTimeMillis() - lastTime;
            lastTime = System.currentTimeMillis();
            update(delta);
            render();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        JFrame frame = new JFrame(Game.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //выход из приложения по нажатию клавиши ESC
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER); //добавляем холст на наш фрейм
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        game.start();
    }

    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void init() {
        turn = 0;
        //World.generate(0);
        World.generateCenter();
        Animals.add();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2); //создаем BufferStrategy для нашего холста
            requestFocus();
            return;
        }

        Graphics g = bs.getDrawGraphics(); //получаем Graphics из созданной нами BufferStrategy
        g.setColor(Color.black); //выбрать цвет
        g.fillRect(0, 0, getWidth(), getHeight()); //заполнить прямоугольник

        Animals.draw(g);

        g.dispose();
        bs.show(); //показать
    }

    public void update(long delta) {
        for(; Animals.size()<250;)
            Animals.add();
        Animals.turn();
        World.turn();
        turn++;
        if(turn>=100){
            turn = 0;
            System.out.println("\nAll nrg on the world = " + World.allNrg()/1000);
            System.out.println("All animals on the world = " + World.allAnimals());
            System.out.println("All animals = " + Animals.size()+"\n");
            Animals.printSpecies();
        }
    }
}
