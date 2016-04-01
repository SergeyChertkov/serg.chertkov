package serg.chertkov.evolution.limbs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sergey on 27.02.2016.
 */
public class SensorTest {
    private Sensor sensor;

    @Before
    public void setUp(){
        sensor = new Sensor(new double[] {10, 0,1,2,3});
    }

    @After
    public void endOfTests(){

    }

    @Test
    public void testSensor() {
        //TODO: something
        double[] actual = sensor.getCoefficients();
        double[] expected = {0,1,2,3};
        double delta = 0.0000001;
        Assert.assertArrayEquals(expected, actual, delta);
        Assert.assertTrue(true);
    }
}