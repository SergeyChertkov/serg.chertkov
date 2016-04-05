package serg.chertkov.evolution.world;

import org.junit.*;
import serg.chertkov.evolution.EvoData;
import serg.chertkov.evolution.database.DBResult;
import serg.chertkov.evolution.database.DataBase;


/**
 * Created by sergey on 12.03.2016.
 */
public class DbWorldTest {

    @BeforeClass
    public static void setUp(){
        DataBase.connect();
    }

    @AfterClass
    public static void endOfTests(){
        DataBase.close();
    }

    @Test
    public void testCreate() throws Exception {
        DBResult res = new DBResult(DataBase.select("SELECT * FROM " +
                DbWorld.table_world + " LIMIT 1"));
        Assert.assertEquals("XY", res.getColumnName(0));
        Assert.assertEquals("TYPE", res.getColumnName(1));
        Assert.assertEquals("NRG", res.getColumnName(2));
        Assert.assertEquals("CORPSE", res.getColumnName(3));
        Assert.assertEquals("ANIMAL", res.getColumnName(4));
    }

    @Test
    public void testSetCellToDB(){
        Cell c = new Ocean(0,0);
        c.setType(EvoData.BIOME_OCEAN);
        c.setNrg(2);
        c.setCorpse(3);
        c.setAnimal(4);
        DbWorld.setCellToDB(c);
        DBResult res = new DBResult(DataBase.select("SELECT * FROM " +
                DbWorld.table_world + " WHERE XY = 0000000000"));
        Assert.assertEquals("|XY|TYPE|NRG|CORPSE|ANIMAL|\n|0|"+
                EvoData.BIOME_OCEAN+"|2|3|4|\n", res.toString());
    }

    @Test
    public void testGet() throws Exception {
        DbWorld.create();
        DataBase.execute("INSERT INTO " +
                DbWorld.table_world + " (XY, TYPE, NRG, CORPSE, ANIMAL) " +
                "VALUES(0000000000, "+EvoData.BIOME_OCEAN+", 2, 3, 4)");
        Cell c = DbWorld.get(0,0);
        Assert.assertEquals(EvoData.BIOME_OCEAN, c.getType());
        Assert.assertEquals(2, c.getNrg());
        Assert.assertEquals(3, c.getCorpse());
        Assert.assertEquals(4, c.getAnimal());
    }

}