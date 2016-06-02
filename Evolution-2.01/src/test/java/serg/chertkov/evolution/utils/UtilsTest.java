package serg.chertkov.evolution.utils;

import org.junit.Assert;
import org.junit.Test;
import serg.chertkov.evolution.world.World;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Chertkov on 3/30/2016.
 */
public class UtilsTest {

    @Test
    public void testMaxIndex(){
        int[] arr = {12,75,68,97,31,24,53,46};
        int actual=Utils.maxIndex(arr);
        int expect=3;
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testMinIndex(){
        int[] arr = {75,68,97,31,24,12,53,46};
        int actual=Utils.minIndex(arr);
        int expect=5;
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testNeuronFunction(){
        double actual;
        double[] expect = {0, 5, 6, 10, 3.5, 1.5, 5.5, 7, 8, 12, 3.9092974, 2.7278923, 6.7278923, 0.8149601, -6.5551196, -2.5551196};
        double delta = 0.0000001;
        for(int i=0; i<=15; i++) {
            actual = Utils.neuronFunction(i, 2, 3, 4);
            Assert.assertEquals(expect[i], actual, delta);
        }
    }

    @Test
    public void testGenerateCoefficient(){
        double[] arr = {0,1,2,3};
        double[] expected = {0,1,2,3,0,1,2,3,0,1,2,3,0,1,2};
        double delta = 0.0000001;
        arr = Utils.generateCoefficient(15,arr);
        Assert.assertArrayEquals(expected, arr, delta);
    }

    @Test
    public void testOffsetCoordinates(){
        int actual;
        int[] offset = {0, 1, -1, 9, -9};
        int[] expect = {5, 6,  4, 4,  6};
        World.generate(1);
        for(int i=0; i<5; i++){
            actual=Utils.offsetCoordinates(5,offset[i]);
            Assert.assertEquals(expect[i], actual);
        }

    }

    @Test
    public void testTransformationCoefficient(){
        int [] arr = {-10, 530, 1, 100, 200, 265, 300, 400, 500, 529};
        double [] expected = {0, 0, -76961.973682,-6.1432807, -0.0004457, 0, 0.0000255, 0.3520625, 4851.637308, 76961.973682};
        double [] actual = new double[arr.length];
        double delta = 0.000001;
        for(int i=0; i<arr.length; i++)
            actual[i] = Utils.transformationCoefficient(arr[i]);
        Assert.assertArrayEquals(expected, actual, delta);
    }
}