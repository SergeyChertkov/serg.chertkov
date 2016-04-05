package serg.chertkov.evolution.world;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sergey on 12.03.2016.
 */
public class CellTest {
    private Cell cell;

    @Before
    public void setUp(){

    }

    @After
    public void endOfTests(){

    }

    @Test
    public void testCell() {
        cell = new Ocean(0,0);
        Assert.assertTrue(cell.getType()==1);
        cell = new Water(0,0);
        Assert.assertTrue(cell.getType()==2);
        cell = new Desert(0,0);
        Assert.assertTrue(cell.getType()==11);
        cell = new Plain(0,0);
        Assert.assertTrue(cell.getType()==12);
        cell = new Forest(0,0);
        Assert.assertTrue(cell.getType()==13);
    }

    @Test
    public void testOcean() {
        cell = new Ocean(0,0);
        cell.setNrg(10);
        for(int i=0; i<50; i++)
            cell.turn();
        Assert.assertTrue(cell.getClass() + " nrg less then 150", cell.getNrg()>150);
        Assert.assertTrue(cell.getClass() + " nrg more then 300", cell.getNrg()<300);
        for(int i=0; i<100; i++)
            cell.turn();
        Assert.assertEquals(1000, cell.getNrg());
    }

    @Test
    public void testWater() {
        cell = new Water(0,0);
        cell.setNrg(10);
        for(int i=0; i<50; i++)
            cell.turn();
        Assert.assertTrue(cell.getClass() + " nrg less then 150", cell.getNrg()>150);
        Assert.assertTrue(cell.getClass() + " nrg more then 300", cell.getNrg()<300);
        for(int i=0; i<100; i++)
            cell.turn();
        Assert.assertEquals(3000, cell.getNrg());
    }

    @Test
    public void testDesert() {
        cell = new Desert(0,0);
        cell.setNrg(10);
        for(int i=0; i<50; i++)
            cell.turn();
        Assert.assertTrue(cell.getClass() + " nrg less then 10", cell.getNrg()>10);
        Assert.assertTrue(cell.getClass() + " nrg more then 20", cell.getNrg()<20);
        for(int i=0; i<1500; i++)
            cell.turn();
        Assert.assertEquals(100, cell.getNrg());
    }

    @Test
    public void testPlain() {
        cell = new Plain(0,0);
        cell.setNrg(10);
        for(int i=0; i<50; i++)
            cell.turn();
        Assert.assertTrue(cell.getClass() + " nrg less then 80", cell.getNrg()>75);
        Assert.assertTrue(cell.getClass() + " nrg more then 150", cell.getNrg()<150);
        for(int i=0; i<200; i++)
            cell.turn();
        Assert.assertEquals(2000, cell.getNrg());
    }

    @Test
    public void testForest() {
        cell = new Forest(0,0);
        cell.setNrg(10);
        for(int i=0; i<50; i++)
            cell.turn();
        Assert.assertTrue(cell.getClass() + " nrg less then 80", cell.getNrg()>75);
        Assert.assertTrue(cell.getClass() + " nrg more then 150", cell.getNrg()<150);
        for(int i=0; i<500; i++)
            cell.turn();
        Assert.assertEquals(5000, cell.getNrg());
    }

}