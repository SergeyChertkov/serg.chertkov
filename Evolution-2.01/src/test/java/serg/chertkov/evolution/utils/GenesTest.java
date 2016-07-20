package serg.chertkov.evolution.utils;

import org.junit.Assert;
import org.junit.Test;


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

    @Test
    public void testGenerateCoefficients(){
        String [] arr = {"", "X", "QWERTY", "ASD", "ZB", "UIOP", "FGHJKL", "CVBNM"};
        double [][] expected = {
                {0},
                {0},
                {0.1357353,-2.6053507,11.9715163},
                {-15226.5162011},
                {-76961.9736824},
                {-0.0000119,0.0008687},
                {-0.8301450,-0.0077787,-0.0000089},
                {-142.6786449,-2738.6227784}
        };
        double [][] actual = new double [arr.length][];
        double delta = 0.0000001;
        for(int i=0; i<arr.length; i++) {
            actual[i] = Genes.generateCoefficients(arr[i]);
            Assert.assertArrayEquals(expected[i], actual[i], delta);
        }

    }
}