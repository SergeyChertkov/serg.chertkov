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
        sensor = new Sensor(5);
    }

    @After
    public void endOfTests(){

    }

    @Test
    public void testGetImpulses() {
        //TODO: something
        Assert.assertTrue(true);
    }
}