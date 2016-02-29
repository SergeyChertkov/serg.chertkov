package serg.chertkov.evolution.limbs;

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
        sensor = new Sensor(5);
    }

    @Test
    public void testGetImpulses() {
        Assert.assertTrue(true);
    }
}