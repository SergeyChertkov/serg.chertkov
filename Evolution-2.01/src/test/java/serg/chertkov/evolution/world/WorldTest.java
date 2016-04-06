package serg.chertkov.evolution.world;

import org.junit.*;
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
            if(i!=max) Assert.assertTrue("The recessive cells is more than 10%", a[i]<10);
            else Assert.assertTrue("The dominant cell is less than 70%", a[i]>70);
        }
    }

}