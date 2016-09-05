package serg.chertkov.evolution.animals;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sergii_Chertkov on 9/2/2016.
 */
public class AnimalPropertyTest {
    @Test
    public void testAnimalProperty(){
        AnimalProperty a = new AnimalProperty(11,22,(short)33,(short)22,(byte)1);
        Assert.assertTrue(a.x==11);
        Assert.assertTrue(a.y==22);
        Assert.assertTrue(a.nrg==33);
        Assert.assertTrue(a.age==22);
        Assert.assertTrue(a.position==1);
    }

    @Test
    public void testAnimalPropertyWithString(){
        try {
            AnimalProperty a = new AnimalProperty("11-22-33-22-1");
            Assert.assertTrue(a.x==11);
            Assert.assertTrue(a.y==22);
            Assert.assertTrue(a.nrg==33);
            Assert.assertTrue(a.age==22);
            Assert.assertTrue(a.position==1);
        } catch (AnimalException e) {
            Assert.fail("can not create AnimalProperty with String property");
        }
    }

    @Test
    public void testSet(){
        try {
            AnimalProperty a = new AnimalProperty("11-22-33-22-1");
            Assert.assertTrue(a.x==11);
            Assert.assertTrue(a.y==22);
            Assert.assertTrue(a.nrg==33);
            Assert.assertTrue(a.age==22);
            Assert.assertTrue(a.position==1);
        } catch (AnimalException e) {
            Assert.fail("can not create AnimalProperty with String property");
        }
    }

    @Test
    public void testToString(){
        AnimalProperty a = new AnimalProperty(11,22,(short)33,(short)22,(byte)1);
        Assert.assertEquals("11-22-33-22-1",a.toString());
    }
}