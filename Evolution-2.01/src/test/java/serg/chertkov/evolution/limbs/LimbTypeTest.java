package serg.chertkov.evolution.limbs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Chertkov on 7/19/2016.
 */
public class LimbTypeTest {
    @Test
    public void testGenerate(){
        int expect = 3;
        LimbType.generate();
        Assert.assertEquals(expect,LimbType.getMover(29).length());
        Assert.assertEquals(expect,LimbType.getAbsorber(2).length());
        Assert.assertEquals(expect,LimbType.getGenitals(0).length());
        Assert.assertEquals(expect,LimbType.getReproductor(0).length());
        Assert.assertEquals(expect,LimbType.getAgeSensation(0).length());
        Assert.assertEquals(expect,LimbType.getHunger(0).length());
        Assert.assertEquals(expect,LimbType.getScaner(3).length());
        Assert.assertEquals(expect,LimbType.getAggressor(0).length());
        Assert.assertEquals(expect,LimbType.getDeffender(0).length());
        Assert.assertEquals(expect,LimbType.getNeuron(0).length());
    }

    @Test
    public void testIfGenLimbExist(){
        LimbType.generate();
        Assert.assertEquals(true,LimbType.ifGenLimbExist(LimbType.getNeuron(0)));
    }

    @Test
    public void testGetTypeOfGen(){
        LimbType.generate();
        for(int i=0; i<30; i++)
            Assert.assertEquals("mover"+i,LimbType.getTypeOfGen(LimbType.getMover(i)));
        for(int i=0; i<3; i++)
            Assert.assertEquals("absorber"+i,LimbType.getTypeOfGen(LimbType.getAbsorber(i)));
        Assert.assertEquals("genitals0",LimbType.getTypeOfGen(LimbType.getGenitals(0)));
        Assert.assertEquals("reproductor0",LimbType.getTypeOfGen(LimbType.getReproductor(0)));
        Assert.assertEquals("ageSensation0",LimbType.getTypeOfGen(LimbType.getAgeSensation(0)));
        Assert.assertEquals("hunger0",LimbType.getTypeOfGen(LimbType.getHunger(0)));
        for(int i=0; i<4; i++)
            Assert.assertEquals("scaner"+i,LimbType.getTypeOfGen(LimbType.getScaner(i)));
        Assert.assertEquals("aggressor0",LimbType.getTypeOfGen(LimbType.getAggressor(0)));
        Assert.assertEquals("deffender0",LimbType.getTypeOfGen(LimbType.getDeffender(0)));
        Assert.assertEquals("neuron0",LimbType.getTypeOfGen(LimbType.getNeuron(0)));
    }
}