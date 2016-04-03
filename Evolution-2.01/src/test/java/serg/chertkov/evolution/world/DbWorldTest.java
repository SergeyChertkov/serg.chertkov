package serg.chertkov.evolution.world;

import org.junit.Test;
import org.junit.Assert;
import serg.chertkov.evolution.database.DBResult;
import serg.chertkov.evolution.database.DataBase;


/**
 * Created by sergey on 12.03.2016.
 */
public class DbWorldTest {

    @Test
    public void testCreate() throws Exception {
        DbWorld.create();
        DataBase db = new DataBase();
        DBResult res = new DBResult(db.select("SELECT * FROM " +
                DbWorld.table_world + " LIMIT 1"));
        Assert.assertEquals("XY", res.getColumnName(0));
        Assert.assertEquals("TYPE", res.getColumnName(1));
        Assert.assertEquals("NRG", res.getColumnName(2));
        Assert.assertEquals("CORPSE", res.getColumnName(3));
        Assert.assertEquals("ANIMAL", res.getColumnName(4));
        db.close();
    }

    @Test
    public void testGet() throws Exception {
        DataBase db = new DataBase();
        db.execute("INSERT INTO " +
                DbWorld.table_world + " (XY, TYPE, NRG, CORPSE, ANIMAL) " +
                "VALUES(0000000000, 1, 2, 3, 4)");
        DBResult res = new DBResult(db.select("SELECT * FROM " +
                DbWorld.table_world + " WHERE XY = 0000000000"));
        Assert.assertEquals("0", res.get(0,0));
        Assert.assertEquals("1", res.get(0,1));
        Assert.assertEquals("2", res.get(0,2));
        Assert.assertEquals("3", res.get(0,3));
        Assert.assertEquals("4", res.get(0,4));
        db.close();
    }

}