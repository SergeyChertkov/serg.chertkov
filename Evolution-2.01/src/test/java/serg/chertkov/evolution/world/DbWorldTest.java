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
        DataBase db = new DataBase();
        DbWorld.create();
        DBResult res = new DBResult(db.select("SELECT * FROM " +
                DbWorld.table_world + " LIMIT 1"));
        Assert.assertTrue("table " + DbWorld.table_world +
                " does not created.", res!=null);
        db.close();
    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testGenerateXY() throws Exception {

    }
}