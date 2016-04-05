package serg.chertkov.evolution;

import serg.chertkov.evolution.database.DBResult;
import serg.chertkov.evolution.database.DataBase;
import serg.chertkov.evolution.world.Cell;
import serg.chertkov.evolution.world.DbWorld;
import serg.chertkov.evolution.world.Ocean;
import serg.chertkov.evolution.world.World;

/**
 * Created by sergey on 12.03.2016.
 */
public class test {
    public static void main (String args[]){
        DataBase.setPrint(true);
        DataBase.connect();
        World w = new World();
        DbWorld.create();
        Cell c = new Ocean();
        DbWorld.setCellToDB(c);
        DBResult res = new DBResult(DataBase.select("SELECT * FROM " +
                DbWorld.table_world + " LIMIT 1"));
        System.out.println(res.getColumnName(0));
//        System.out.println(Integer.valueOf(DbWorld.generateXY(13,45624)));
        DataBase.close();
    }
}
