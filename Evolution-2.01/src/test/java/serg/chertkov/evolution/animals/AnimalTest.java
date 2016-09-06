package serg.chertkov.evolution.animals;

import org.junit.Test;
import org.junit.Assert;


/**
 * Created by Sergii_Chertkov on 7/29/2016.
 */
public class AnimalTest {

    @Test
    public void testAnimal(){
        Animal a = new Animal();
        Assert.assertEquals("0=AZ=0-0-0-0-0", a.toString());
        Assert.assertEquals("Z",a.getCleanGenes(0));
    }

    @Test
    public void testAnimalWithProperty(){
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

    @Test
    public void testEquals(){
        try {
            Animal a1 = new Animal("0=DSAQWEARTYSDXAQCVBWXERTYUIOACVBZQW=1-2-3-2-1");
            Animal a2 = new Animal("1=AQWEQARTYAQCVBRWXACVB=2-3-2-3-2");
            Animal a3 = new Animal("0=DSAQWEARTYSDXAQCVBWXERTYUIOACVRZQW=1-2-3-2-1");
            Assert.assertEquals(a1, a2);
            Assert.assertNotEquals(a1, "DSAQWEARTYSDXAQCVBWXERTYUIOACVBZQW");
            Assert.assertNotEquals(a1, a3);
        } catch (AnimalException e) {
            e.printStackTrace();
        }
    }
}