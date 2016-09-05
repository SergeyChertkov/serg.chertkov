package serg.chertkov.evolution.animals;

import org.junit.Test;
import org.junit.Assert;


/**
 * Created by Sergii_Chertkov on 7/29/2016.
 */
public class AnimalTest {

    @Test
    public void testAnimal(){
        String [] expect = {"QWEART","RT", "QCVBW", "CVB"};
        AnimalProperty property = new AnimalProperty(1,2,(short)3,(short)2,(byte)1);
        Animal a = new Animal("DSAQWEARTYSDXAQCVBWXERTYUIOACVBZQW",property);
        Assert.assertEquals("0=DSAQWEARTYSDXAQCVBWXERTYUIOACVBZQW=1-2-3-2-1", a.toString());
        for (int i=0; i<expect.length; i++ )
            Assert.assertEquals(expect[i],a.getCleanGenes(i));
    }

    @Test
    public void testAnimalWithString(){
        try{
            String [] expect = {"QWEART","RT", "QCVBW", "CVB"};
            Animal a = new Animal("0=DSAQWEARTYSDXAQCVBWXERTYUIOACVBZQW=1-2-3-2-1");
            Assert.assertEquals("0=DSAQWEARTYSDXAQCVBWXERTYUIOACVBZQW=1-2-3-2-1", a.toString());
            for (int i=0; i<expect.length; i++ )
                Assert.assertEquals(expect[i],a.getCleanGenes(i));
        } catch (AnimalException e) {
            e.printStackTrace();
            Assert.fail("can not create AnimalProperty with String property");
        }
    }
}