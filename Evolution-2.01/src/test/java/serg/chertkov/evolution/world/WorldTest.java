package serg.chertkov.evolution.world;

import serg.chertkov.evolution.utils.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sergey on 12.03.2016.
 */
public class WorldTest {
    private World world;

    @Before
    public void setUp(){

    }

    @After
    public void endOfTests(){

    }

    @Test
    public void testWorld(){
        World.generate();
        Assert.assertEquals(100, World.size);
        World.generate(-123);
        Assert.assertEquals(100, World.size);
        World.generate(0);
        Assert.assertEquals(100, World.size);
        World.generate(11);
        Assert.assertEquals(20, World.size);
        World.generate(19);
        Assert.assertEquals(20, World.size);
    }

    @Test
    public void testGenerate(){
        world.generate();
        int a[] = {0, 0, 0, 0, 0};
        for (int i=0; i<100; i++){
                switch(world.getCell(i).type){
                    case 1: a[0]++; break;
                    case 2: a[1]++; break;
                    case 11: a[2]++; break;
                    case 12: a[3]++; break;
                    case 13: a[4]++; break;
                }
            }
        int max = Utils.MaxIndex(a);
        for(int i=1; i< a.length; i++)
            if(i!=max) Assert.assertTrue("The recessive cells is more than 10%", a[i]<10);
        else Assert.assertTrue("The dominant cell is less than 70%", a[i]>70);
    }

}