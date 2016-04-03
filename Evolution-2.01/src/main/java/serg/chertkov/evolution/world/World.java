package serg.chertkov.evolution.world;

import java.util.ArrayList;

/**
 * Created by sergey on 12.03.2016.
 */
public class World {
    public static int size;
    private static ArrayList<Cell> cells;
    public static int startNrg = 1;

    public World(){
        size = 100;
        cells = new ArrayList<Cell>();
    }

    public World(int size){
        if(size>0)
            this.size = size + (10-size%10);
        else
            this.size = 100;
        cells = new ArrayList<Cell>();
    }

    public Cell get(int i){
        return cells.get(i);
    }

    public World generate(){
        DbWorld.create();
        Cell c;
        for (int x=0; x<size/10; x++)
            for (int y=0; y<size/10; y++) {

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
        return this;
    }

    private Cell ocean(){
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

    private Cell water(){
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

    private Cell desert(){
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

    private Cell plain(){
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

    private Cell forest(){
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
