package serg.chertkov.evolution.limbs;

import org.junit.Assert;
import org.junit.Test;
import serg.chertkov.evolution.limbs.utils.LimbFactory;
import serg.chertkov.evolution.limbs.utils.LimbType;

/**
 * Created by Sergii_Chertkov on 7/20/2016.
 */
public class LimbFactoryTest {
    @Test
    public void testCreate (){
        LimbType.generate();
        Limb [] actual = {
                LimbFactory.create(LimbType.getMover(0)),
                LimbFactory.create(LimbType.getAbsorber(0)),
                LimbFactory.create(LimbType.getGenitals(0)),
                LimbFactory.create(LimbType.getReproductor(0)),
                LimbFactory.create(LimbType.getAgeSensation(0)),
                LimbFactory.create(LimbType.getHunger(0)),
                LimbFactory.create(LimbType.getScanner(0)),
                LimbFactory.create(LimbType.getAggressor(0)),
                LimbFactory.create(LimbType.getDeffender(0)),
                LimbFactory.create(LimbType.getNeuron(0))
        };
        String [] expect = {
                "Mover","Absorber","Genitals","Reproductor","AgeSensation",
                "Hunger","Scanner","Aggressor","Deffender","Neuron"
        };
        for (int i=0; i<expect.length; i++)
            Assert.assertEquals(expect[i],actual[i].getClass().getSimpleName());
    }
}