package serg.chertkov.evolution.limbs.sensor;

import org.junit.*;
import serg.chertkov.evolution.limbs.Sensor;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Chertkov on 3/31/2016.
 */
public class ScannerTest {
    private Scanner scanner;

    @Before
    public void setUp(){
        scanner = new Scanner(new double[] {10, 0,1,2,3});
    }

    @After
    public void endOfTests(){

    }
    @Test
    public void testGenerateXYType() {
        //scanner.
    }

}