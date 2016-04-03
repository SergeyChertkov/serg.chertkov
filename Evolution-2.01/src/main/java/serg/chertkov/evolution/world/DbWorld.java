package serg.chertkov.evolution.world;

import serg.chertkov.evolution.database.DBResult;
import serg.chertkov.evolution.database.DataBase;

/**
 * Created by sergey on 12.03.2016.
 */
public class DbWorld {
    public static String table_world = "WORLD";

    public static void create(){
        DataBase db = new DataBase();
        db.execute("DROP TABLE " + table_world);
        db.execute("CREATE TABLE " + table_world +
                " (XY int primary key, TYPE int, NRG int, CORPSE int, ANIMAL int)");
        //System.out.println("table " + table_world + " was created.");
        db.close();
    }

    public static Cell get(int x, int y){
        DataBase db = new DataBase();

        DBResult res = new DBResult(db.select("SELECT XY FROM " + table_world +
                " WHERE XY=" + generateXY(x,y)));
        db.close();
        Cell c = null;
        if(res!=null){
            int type = Integer.valueOf(res.get(0, 2));
            switch(type){
                case 1: c = new Ocean(); break;
                case 2: c = new Water(); break;
                case 11: c = new Desert(); break;
                case 12: c = new Plain(); break;
                case 13: c = new Forest(); break;
            }
        }
        return c;
    }

    private static String generateXY(int x, int y){
        String XY = "0000000000";
        String X = String.valueOf(x);
        String Y = String.valueOf(y);
        return XY.substring(0,5-X.length()) + X + XY.substring(5,10-Y.length()) + Y;
    }

    public static void setCellToDB(Cell c){
        DataBase db = new DataBase();
        String xy = generateXY(c.getX(),c.getY());
        DBResult res = new DBResult(db.select("SELECT * FROM " +
                DbWorld.table_world + " WHERE XY = " + xy));
        if(res.get(0,0)==null)
            db.execute("INSERT INTO " +
                    DbWorld.table_world + " (XY, TYPE, NRG, CORPSE, ANIMAL) " +
                    "VALUES(" + xy + ", " + String.valueOf(c.getType()) + ", " +
                    String.valueOf(c.getNrg()) + ", " + String.valueOf(c.getCorpse() +
                    ", " + String.valueOf(c.getAnimal())));
        else
            db.execute("UPDATE " +
                    DbWorld.table_world + " SET " +
                    "TYPE = " + String.valueOf(c.getType()) +
                    ", NRG = " + String.valueOf(c.getNrg()) +
                    ", CORPSE = " + String.valueOf(c.getCorpse()) +
                    ", ANIMAL  = " + String.valueOf(c.getAnimal()) +
                    " WHERE XY = " + xy);
        db.close();
    }
}
