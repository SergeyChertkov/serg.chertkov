package serg.chertkov.evolution.world;

import java.util.ArrayList;

/**
 * Created by sergey on 12.03.2016.
 */
public class World {
    public static int size;
    private static ArrayList<Cell> cells;
    public static int startNrg = 1;

    public static Cell getCell(int i){
        return cells.get(i);
    }

    public static int getData(int dataType, int i) {
        return cells.get(i).getData(dataType);
    }

    public static int getX(int i) {return cells.get(i).getX();}

    public static int getY(int i) {return cells.get(i).getY();}

    public static int getType(int i) {return cells.get(i).getType();}

    public static int getNrg(int i) {return cells.get(i).getNrg();}

    public static int getCorpse(int i) {return cells.get(i).getCorpse();}

    public static int getAnimal(int i) {return cells.get(i).getAnimal();}

    public static int getVolume(int i) {return cells.get(i).getVolume();}

    public static Cell getCell(int x, int y){
        return cells.get(size*x+y);
    }

    public static int getData(int dataType, int x, int y) {
        return cells.get(size*x+y).getData(dataType);
    }

    public static int getType(int x, int y) {return cells.get(size*x+y).getType();}

    public static int getNrg(int x, int y) {return cells.get(size*x+y).getNrg();}

    public static int getCorpse(int x, int y) {return cells.get(size*x+y).getCorpse();}

    public static int getAnimal(int x, int y) {return cells.get(size*x+y).getAnimal();}

    public static int getVolume(int x, int y) {return cells.get(size*x+y).getVolume();}

    public static void generate(){
        generate(100);
    }

    public static void generate(int size){
        if(size>0)
            World.size = size + (10-size%10);
        else
            World.size = 100;
        cells = new ArrayList<Cell>();

        for (int x=0; x<World.size/10; x++)
            for (int y=0; y<World.size/10; y++) {

     public World generate(){
        DbWorld.create();
        Cell c;
        for (int x=0; x<size/10; x++)
            for (int y=0; y<size/10; y++) 
                switch ((int) (5 * Math.random())) {
                    case 1:
                        for (int i=0; i<10; i++)
                            for (int j=0; j<10; j++) {
                                c = ocean();
                                cells.add(c);
                                DbWorld.setCellToDB(c);
                            }
                        break;
                    case 2:
                        for (int i=0; i<10; i++)
                            for (int j=0; j<10; j++){
                                c = water();
                                cells.add(c);
                                DbWorld.setCellToDB(c);
                            }
                        break;
                    case 3:
                        for (int i=0; i<10; i++)
                            for (int j=0; j<10; j++){
                                c = desert();
                                cells.add(c);
                                DbWorld.setCellToDB(c);
                            }
                        break;
                    case 4:
                        for (int i=0; i<10; i++)
                            for (int j=0; j<10; j++){
                                c = plain();
                                cells.add(c);
                                DbWorld.setCellToDB(c);
                            }
                        break;
                    case 5:
                        for (int i=0; i<10; i++)
                            for (int j=0; j<10; j++){
                                c = forest();
                                cells.add(c);
                                DbWorld.setCellToDB(c);
                            }
                        break;
                    default:
                        break;
                }
            }
    }

    private static Cell ocean(){
        int t = (int)(100*Math.random());
        if (t<80)
            return new Ocean();
        else if (t<85)
            return new Water();
        else if (t<90)
            return new Desert();
        else if (t<95)
            return new Plain();
        else return new Forest();
    }

    private static Cell water(){
        int t = (int)(100*Math.random());
        if (t<80)
            return new Water();
        else if (t<85)
            return new Ocean();
        else if (t<90)
            return new Desert();
        else if (t<95)
            return new Plain();
        else return new Forest();
    }

    private static Cell desert(){
        int t = (int)(100*Math.random());
        if (t<80)
            return new Desert();
        else if (t<85)
            return new Ocean();
        else if (t<90)
            return new Water();
        else if (t<95)
            return new Plain();
        else return new Forest();
    }

    private static Cell plain(){
        int t = (int)(100*Math.random());
        if (t<80)
            return new Plain();
        else if (t<85)
            return new Ocean();
        else if (t<90)
            return new Water();
        else if (t<95)
            return new Desert();
        else return new Forest();
    }

    private static Cell forest(){
        int t = (int)(100*Math.random());
        if (t<80)
            return new Forest();
        else if (t<85)
            return new Ocean();
        else if (t<90)
            return new Ocean();
        else if (t<95)
            return new Desert();
        else return new Plain();
    }

}
