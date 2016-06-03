package serg.chertkov.evolution.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Chertkov on 6/2/2016.
 */
public class GenesTest {
    @Test
    public void testCleanGenes (){
        String [] arr = {"QWERTYSDFG", "SDASDFRETHUJ", "SADCFXTGYHZ", "ASDFGHVZ","SDAQWEARTYSDAFGXGHJKZFGTAPOIK"};
        String [][] expected ={{},{"SDFRETHUJ"},{"DCF"},{"SDFGHV"},{"QWEART","RT","FG","POIK"}};
        String [][] actual = new String[arr.length][];
        for(int i=0; i<arr.length; i++)
            actual[i] = Genes.cleanGenes(arr[i]);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTransformationGenes(){
        String [] arr = {"QWERTY", "ASD", "Z", "R", "UIOP", "FGHJKL", "CVBNM"};
        int [] expected = {109196088, 417, 0, 17, 126239, 33950932, 816029};
        int [] actual = new int [arr.length];
        for(int i=0; i<arr.length; i++)
            actual[i] = Genes.transformationGenes(arr[i]);
        Assert.assertArrayEquals(expected, actual);
    }

}