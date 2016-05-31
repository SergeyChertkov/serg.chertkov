package Fauna;

import Flora.World;
import Game.Game;
import java.awt.Graphics;
import Graphics.Sprite;

/**
 * Created by sergey on 30.05.2016.
 */
public class Animal {
    public static final int GEN_SIZE=2*98;
    private String genes;
    private int x, y;
    private int maxNrg;
    private int nrg;
    private int maxAge;
    private int age;
    private int k[][];
    private String created = "man.png";
    private String reproducible = "reproducable.png";
    private Sprite sprite;

    private Animal (String GENES, int X, int Y, int NRG){
        World.get(X,Y).animalComes();

        x = X;
        y = Y;

        if(GENES.length()!=GEN_SIZE){
            Integer gen;
            genes = "";
            for (int i=0; i<GEN_SIZE; i++){
                gen = (int)(Math.random()*10);
                genes += gen.toString();
            }
        }
        else genes = GENES;

        maxAge = readGenes(genes.substring(0,2))*10+10;
        maxNrg = readGenes(genes.substring(2,4))*10+10;
        age = 0;
        nrg = NRG;
        if(nrg>maxNrg)
            nrg=maxNrg;

        k = new int[6][16];
        for(int i=0; i<6; i++)
            for(int j=0; j<16; j++){
                k[i][j] = readGenes(genes.substring(4+i*32+j*2, 4+i*32+j*2+2))-50;
            }

        sprite = new Sprite(created);
    }

    public static Animal animalGenerator (){
        int X = (int) (Math.random()*World.WORLD_X);
        int Y = (int) (Math.random()*World.WORLD_Y);
        if(!World.ifAnimal(X,Y))
            return new Animal ("",X,Y,100);
        else return null;
    }

    public static Animal animalGenerator (String GENES, int X, int Y, int NRG){
        if(!World.ifAnimal(X,Y))
            return new Animal (GENES,X,Y,NRG);
        else return null;
    }

    public int readGenes(String gen){
        return Integer.valueOf(gen);
    }

    public void setImage(String image){
        sprite = new Sprite(image);
    }

    public void draw(Graphics g){
        sprite.draw(g, Game.step*x, Game.step*y);
    }

    public String getGenes(){
        return genes;
    }

    public String toString(){
        String text = genes + "\n";
        text += "XY = [" + x + ";" + y + "]\n";
        text += "nrg = " + nrg + "/" + maxNrg + "\n";
        text += "age = " + age + "/" + maxAge + "\n";
        for(int i=0; i<6; i++){
            text += "k[" + i + "]: ";
            for(int j=0; j<16; j++)
                text += k[i][j] + "; ";
            text += "\n";
        }
        return text;
    }

    public int getActionImpulse(int number){
        if(number>5)
            return 0;
        int impulse=0;
        int [] data = new int [8];
        data[0] = World.getNrg(x,y)*100/ World.maxNrg;
        data[1] = World.getNrg(x,y-1)*100/ World.maxNrg;//up
        data[2] = World.getNrg(x+1,y)*100/ World.maxNrg;//right
        data[3] = World.getNrg(x,y+1)*100/ World.maxNrg;//down
        data[4] = World.getNrg(x-1,y)*100/ World.maxNrg;//left
        data[5] = nrg;
        data[6] = age*100/maxAge;
        data[7] = (int) (Math.random()*100);
        for (int i=0; i<8; i++)
            impulse += (k[number][i*2]-45)*(data[i] + k[number][i*2+1]-45);
        return impulse;
    }

    public void turn(){
        int [] action = new int[6];
        for (int i=0; i<6; i++)
            action[i] = getActionImpulse(i);
        int max = maxIndex(action);
        if(action[max]>0)
            switch(max){
                case 0: eat(); break;
                case 1: reproduce(); break;
                case 2: moveUp(); break;
                case 3: moveRight(); break;
                case 4: moveDown(); break;
                case 5: moveLeft(); break;
            }
        nrg--;
        age--;
        if (nrg<=0 || age >= maxAge)
            death();
    }

    private int maxIndex(int [] arr){
        int max = 0;
        for(int i=1; i<arr.length; i++)
            if(arr[max]<arr[i])max = i;
        return max;
    }

    private void eat(){
        nrg+= World.eat(x,y,25);
        nrg-=2;
    }

    private void reproduce() {
        Animal new_animal = null;
        nrg = nrg / 2 - 5;
        if (nrg > 2)
            switch ((int) (Math.random() * 4)) {
                case 0:
                    if (y <= 0 && !World.ifAnimal(x, World.WORLD_Y - 1)) {
                        if(World.TOR)
                            new_animal = new Animal(mutation(), x, World.WORLD_Y, nrg);
                    } else if (!World.ifAnimal(x, y - 1)) {
                        new_animal = new Animal(mutation(), x, y--, nrg);
                    }
                    break;
                case 1:
                    if (x >= World.WORLD_X - 1 && !World.ifAnimal(0, y)) {
                        if(World.TOR)
                            new_animal = new Animal(mutation(), 0, y, nrg);
                    } else if (!World.ifAnimal(x + 1, y)) {
                        new_animal = new Animal(mutation(), x++, y, nrg);
                    }
                    break;
                case 2:
                    if (y >= World.WORLD_Y - 1 && !World.ifAnimal(x, 0)) {
                        if(World.TOR)
                            new_animal = new Animal(mutation(), x, 0, nrg);
                    } else if (!World.ifAnimal(x, y + 1)) {
                        new_animal = new Animal(mutation(), x, y++, nrg);
                    }
                    break;
                case 4:
                    if (x <= 0 && !World.ifAnimal(World.WORLD_X - 1, y)) {
                        if(World.TOR)
                            new_animal = new Animal(mutation(), World.WORLD_X, y, nrg);
                    } else if (!World.ifAnimal(x - 1, y)) {
                        new_animal = new Animal(mutation(), x--, y, nrg);
                    }
                    break;
                default:
                    new_animal = null;
            }
            if (new_animal != null) {
                new_animal.setImage(reproducible);
                Animals.add(new_animal);
            }
    }

    private void moveUp(){
        nrg -= 5;
        if(y<=0){
            if(!World.ifAnimal(x,World.WORLD_Y-1)){
                if(World.TOR) {
                    World.animalLeaves(x, y);
                    y = World.WORLD_Y - 1;
                    World.animalComes(x, y);
                }
            }
        } else if (!World.ifAnimal(x,y-1)){
            World.animalLeaves(x,y);
            y--;
            World.animalComes(x,y);
        }
    }

    private void moveRight(){
        nrg -= 5;
        if(x>= World.WORLD_X-1){
            if(!World.ifAnimal(0,y)) {
                if(World.TOR) {
                    World.animalLeaves(x, y);
                    x = 0;
                    World.animalComes(x, y);
                }
            }
        } else if (!World.ifAnimal(x+1,y)){
            World.animalLeaves(x,y);
            x++;
            World.animalComes(x,y);
        }
    }

    private void moveDown(){
        nrg -= 5;
        if(y>= World.WORLD_Y-1){
            if(!World.ifAnimal(x,0)) {
                if(World.TOR) {
                    World.animalLeaves(x, y);
                    y = 0;
                    World.animalComes(x, y);
                }
            }
        } else if (!World.ifAnimal(x,y+1)){
            World.animalLeaves(x,y);
            y++;
            World.animalComes(x,y);
        }
    }

    private void moveLeft(){
        nrg -= 5;
        if(x<=0){
            if(!World.ifAnimal(World.WORLD_X-1,y)){
                if(World.TOR) {
                    World.animalLeaves(x, y);
                    x = World.WORLD_X - 1;
                    World.animalComes(x, y);
                }
            }
        } else if (!World.ifAnimal(x-1,y)){
            World.animalLeaves(x,y);
            x--;
            World.animalComes(x,y);
        }
    }

    private void death(){
        World.animalLeaves(x,y);
        Animals.remove(this);
    }

    private String mutation (){
        int muta = (int)(Math.random()*10);
        String new_genes = genes;
        Integer rand_gen;
        if(muta==0){
            int number = (int) (Math.random()*GEN_SIZE);
            rand_gen = (int) (Math.random()*10);
            new_genes = new_genes.substring(0,number)+rand_gen.toString()+
                    new_genes.substring(number+1,new_genes.length());
        }
        //System.out.println(new_genes);
        return new_genes;
    }
}
