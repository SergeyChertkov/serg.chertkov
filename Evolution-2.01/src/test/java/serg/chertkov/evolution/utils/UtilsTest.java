package serg.chertkov.evolution.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Chertkov on 3/30/2016.
 */
public class UtilsTest {

    @Test
    public void testGenerateCoefficient() throws Exception {
        double[] arr = {0,1,2,3};
        double[] expected = {0,1,2,3,0,1,2,3,0,1,2,3,0,1,2};
        double delta = 0.0000001;
        arr = Utils.generateCoefficient(15,arr);
        Assert.assertArrayEquals(expected, arr, delta);
    }
}