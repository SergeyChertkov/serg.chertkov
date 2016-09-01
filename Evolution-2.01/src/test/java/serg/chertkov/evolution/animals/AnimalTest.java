package serg.chertkov.evolution.animals;

import org.junit.Test;
import org.junit.Assert;


/**
 * Created by Sergii_Chertkov on 7/29/2016.
 */
public class AnimalTest {

    @Test
    public void testAnimal(){
        Animal a = new Animal("",new AnimalProperty(1,1,1,1,1));
        Assert.assertTrue(a!=null);
    }

}