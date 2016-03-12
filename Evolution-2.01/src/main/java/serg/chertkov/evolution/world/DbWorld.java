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
        DBResult res = new DBResult(db.select("SELECT * FROM " + table_world + " LIMIT 1"));
        if(res==null){
            db.execute("CREATE TABLE " + table_world +
                    " (XY int primary key, TYPE int, NRG int, CORPSE int, ANIMAL int");
            System.out.println("table " + table_world + " was created.");
        }
        else{
            System.out.println("table " + table_world + " is already exists.");
        }
        db.close();
    }

    public static Cell get(int x, int y){
        DataBase db = new DataBase();

        DBResult res = new DBResult(db.select("SELECT XY FROM " + table_world +
                " WHERE XY=" + generateXY(x,y)));
        db.close();
        return null;
    }

    public static String generateXY(int x, int y){
        String XY = "0000000000";
        String X = String.valueOf(x);
        String Y = String.valueOf(y);
        return XY.substring(0,5-X.length()) + X + XY.substring(5,10-Y.length()) + Y;
    }
}
