package serg.chertkov.evolution.world;

import org.junit.*;
import serg.chertkov.evolution.EvoData;
import serg.chertkov.evolution.database.DataBase;
import serg.chertkov.evolution.utils.*;

/**
 * Created by sergey on 12.03.2016.
 */
public class WorldTest {

    @BeforeClass
    public static void setUp(){
        DataBase.connect();
    }

    @AfterClass
    public static void endOfTests(){
        DataBase.close();
    }

    //@Ignore
    @Test
    public void testWorld(){
        World.generate();
        Assert.assertEquals(100, World.size());
        World.generate(-12);
        Assert.assertEquals(100, World.size());
        World.generate(5);
        Assert.assertEquals(50, World.size());
    }

    @Test
    public void testGenerate(){
        World.generate(1);
        int a[] = {0, 0, 0, 0, 0};
        for (int i=0; i<100; i++){
            switch(World.getCell(i).getType()){
                case 1: a[0]++; break;
                case 2: a[1]++; break;
                case 11: a[2]++; break;
                case 12: a[3]++; break;
                case 13: a[4]++; break;
                default:
            }
        }
        int max = Utils.maxIndex(a);
        for(int i=0; i< a.length; i++){
            if(i!=max) Assert.assertTrue("The recessive cells is more than 15%", a[i]<15);
            else Assert.assertTrue("The dominant cell is less than 70%", a[i]>70);
        }
    }

    @Test
    public void testGetterSetterByID() {
        World.generate(1);
        Cell c;
        for (int i = 0; i < 100; i++) {
            Assert.assertTrue(World.getType(i) > 0);
            Assert.assertEquals(1, World.getNrg(i));
            Assert.assertEquals(0, World.getCorpse(i));
            Assert.assertEquals(0, World.getAnimal(i));
            Assert.assertEquals(0, World.getVolume(i));
            Assert.assertEquals(i / 10, World.getX(i));
            Assert.assertEquals(i % 10, World.getY(i));

            Assert.assertTrue(World.getData(EvoData.CELLS_BIOME, i) > 0);
            Assert.assertEquals(1, World.getData(EvoData.CELLS_NRG, i));
            Assert.assertEquals(0, World.getData(EvoData.CELLS_CORPSE, i));
            Assert.assertEquals(0, World.getData(EvoData.CELLS_ANIMAL, i));
            Assert.assertEquals(0, World.getData(EvoData.CELLS_VOLUME, i));

            c = World.getCell(i);
            Assert.assertTrue(c.getType() > 0);
            Assert.assertEquals(1, c.getNrg());
            Assert.assertEquals(0, c.getCorpse());
            Assert.assertEquals(0, c.getAnimal());
            Assert.assertEquals(0, c.getVolume());
            Assert.assertEquals(i / 10, c.getX());
            Assert.assertEquals(i % 10, c.getY());
        }
    }

    @Test
    public void testGetterSetterByCoordinates(){
        World.generate(1);
        Cell c;
        for(int x=0; x<10; x++)
            for(int y=0; y<10; y++) {
                Assert.assertTrue(World.getType(x, y) > 0);
                Assert.assertEquals(1, World.getNrg(x, y));
                Assert.assertEquals(0, World.getCorpse(x, y));
                Assert.assertEquals(0, World.getAnimal(x, y));
                Assert.assertEquals(0, World.getVolume(x, y));

                Assert.assertTrue(World.getData(EvoData.CELLS_BIOME, x, y) > 0);
                Assert.assertEquals(1, World.getData(EvoData.CELLS_NRG, x, y));
                Assert.assertEquals(0, World.getData(EvoData.CELLS_CORPSE, x, y));
                Assert.assertEquals(0, World.getData(EvoData.CELLS_ANIMAL, x, y));
                Assert.assertEquals(0, World.getData(EvoData.CELLS_VOLUME, x, y));

                c = World.getCell(x, y);
                Assert.assertTrue(c.getType() > 0);
                Assert.assertEquals(1, c.getNrg());
                Assert.assertEquals(0, c.getCorpse());
                Assert.assertEquals(0, c.getAnimal());
                Assert.assertEquals(0, c.getVolume());
                Assert.assertEquals(x, c.getX());
                Assert.assertEquals(y, c.getY());
            }
    }

}