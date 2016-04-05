package serg.chertkov.evolution.world;

import serg.chertkov.evolution.EvoData;
import serg.chertkov.evolution.database.DBResult;
import serg.chertkov.evolution.database.DataBase;

/**
 * Created by sergey on 12.03.2016.
 */
public class DbWorld {
    public static String table_world = "WORLD";

    public static void create(){
        DataBase.connect();
        DataBase.execute("DROP TABLE " + table_world);
        DataBase.execute("CREATE TABLE " + table_world +
                " (XY int primary key, TYPE int, NRG int, CORPSE int, ANIMAL int)");
        //System.out.println("table " + table_world + " was created.");
    }

    public static Cell get(int x, int y){
        DataBase.connect();
        DBResult res = new DBResult(DataBase.select("SELECT * FROM " +
                DbWorld.table_world + " WHERE XY = " + generateXY(x,y)));
        Cell c = null;
        if(res!=null){
            int type = Integer.valueOf(res.get(0, 2));
            switch(type){
                case EvoData.BIOME_OCEAN: c = new Ocean(x,y); break;
                case EvoData.BIOME_WATER: c = new Water(x,y); break;
                case EvoData.BIOME_DESERT: c = new Desert(x,y); break;
                case EvoData.BIOME_PLAIN: c = new Plain(x,y); break;
                case EvoData.BIOME_FOREST: c = new Forest(x,y); break;
            }
            c.setType(Integer.valueOf(res.get(0, 1)));
            c.setNrg(Integer.valueOf(res.get(0, 2)));
            c.setCorpse(Integer.valueOf(res.get(0, 3)));
            c.setAnimal(Integer.valueOf(res.get(0, 4)));
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
        DataBase.connect();
        String xy = generateXY(c.getX(),c.getY());
        DBResult res = new DBResult(DataBase.select("SELECT * FROM " +
                DbWorld.table_world + " WHERE XY = " + xy));
        if(res.get(0,0)==null)
            DataBase.execute("INSERT INTO " +
                    DbWorld.table_world + " (XY, TYPE, NRG, CORPSE, ANIMAL) " +
                    "VALUES(" + xy + ", " + String.valueOf(c.getType()) + ", " +
                    String.valueOf(c.getNrg()) + ", " + String.valueOf(c.getCorpse()) +
                    ", " + String.valueOf(c.getAnimal())+")");
        else
            DataBase.execute("UPDATE " +
                    DbWorld.table_world + " SET " +
                    "TYPE = " + String.valueOf(c.getType()) +
                    ", NRG = " + String.valueOf(c.getNrg()) +
                    ", CORPSE = " + String.valueOf(c.getCorpse()) +
                    ", ANIMAL  = " + String.valueOf(c.getAnimal()) +
                    " WHERE XY = " + xy);
    }
}
