package serg.chertkov.evolution.world;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import serg.chertkov.evolution.animals.Animal;
import serg.chertkov.evolution.animals.AnimalProperty;
import serg.chertkov.evolution.utils.EvoData;

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
    public void testGetData() {
        Animal a = new Animal("0",new AnimalProperty(1,1,(short)1,(short)1,(byte)1));
        cell = new Ocean(0,0);
        cell.setNrg(2);
        cell.setCorpse(3);
        cell.setAnimal(a);
        cell.setVolume(5);

        Assert.assertEquals(2, cell.getData(EvoData.CELLS_NRG));
        Assert.assertEquals(3, cell.getData(EvoData.CELLS_CORPSE));
        Assert.assertEquals(0, cell.getData(EvoData.CELLS_ANIMAL));
        Assert.assertEquals(5, cell.getData(EvoData.CELLS_VOLUME));
    }

    @Test
    public void testOcean() {
        int nrg = 0;
        int retry = 10;
        for(int j=0; j<retry; j++) {
            cell = new Ocean(0,0);
            cell.setNrg(10);
            for (int i = 0; i < 50; i++)
                cell.turn();
            nrg += cell.getNrg();
        }
        Assert.assertTrue(cell.getClass() + " nrg less then 150", nrg/retry>150);
        Assert.assertTrue(cell.getClass() + " nrg more then 300", nrg/retry<300);
        for(int i=0; i<100; i++)
            cell.turn();
        Assert.assertEquals(1000, cell.getNrg());
    }

    @Test
    public void testWater() {
        int nrg = 0;
        int retry = 10;
        for(int j=0; j<retry; j++) {
            cell = new Water(0,0);
            cell.setNrg(10);
            for (int i = 0; i < 50; i++)
                cell.turn();
            nrg += cell.getNrg();
        }
        Assert.assertTrue(cell.getClass() + " nrg less then 150", nrg/retry>150);
        Assert.assertTrue(cell.getClass() + " nrg more then 300", nrg/retry<300);
        for(int i=0; i<100; i++)
            cell.turn();
        Assert.assertEquals(3000, cell.getNrg());
    }

    @Test
    public void testDesert() {
        int nrg = 0;
        int retry = 10;
        for(int j=0; j<retry; j++) {
            cell = new Desert(0,0);
            cell.setNrg(10);
            for (int i = 0; i < 50; i++)
                cell.turn();
            nrg += cell.getNrg();
        }
        Assert.assertTrue(cell.getClass() + " nrg less then 10", nrg/retry>10);
        Assert.assertTrue(cell.getClass() + " nrg more then 20", nrg/retry<20);
        for(int i=0; i<1500; i++)
            cell.turn();
        Assert.assertEquals(100, cell.getNrg());
    }

    @Test
    public void testPlain() {
        int nrg = 0;
        int retry = 10;
        for(int j=0; j<retry; j++) {
            cell = new Plain(0,0);
            cell.setNrg(10);
            for (int i = 0; i < 50; i++)
                cell.turn();
            nrg += cell.getNrg();
        }
        Assert.assertTrue(cell.getClass() + " nrg less then 80", nrg/retry>75);
        Assert.assertTrue(cell.getClass() + " nrg more then 150", nrg/retry<150);
        for(int i=0; i<200; i++)
            cell.turn();
        Assert.assertEquals(2000, cell.getNrg());
    }

    @Test
    public void testForest() {
        int nrg = 0;
        int retry = 10;
        for(int j=0; j<retry; j++) {
            cell = new Forest(0,0);
            cell.setNrg(10);
            for (int i = 0; i < 50; i++)
                cell.turn();
            nrg += cell.getNrg();
        }
        Assert.assertTrue(cell.getClass() + " nrg less then 80", nrg/retry>75);
        Assert.assertTrue(cell.getClass() + " nrg more then 150", nrg/retry<150);
        for(int i=0; i<500; i++)
            cell.turn();
        Assert.assertEquals(5000, cell.getNrg());
    }

}