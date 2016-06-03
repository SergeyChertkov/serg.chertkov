package serg.chertkov.evolution.limbs.sensor;

import serg.chertkov.evolution.limbs.Sensor;

/**
 * Created by sergey on 27.02.2016.
 */
public class AgeSensation extends Sensor {
    public AgeSensation(double []coefficient) {
        super(coefficient);
    }

    @Override
    public double dataCatch(int current_age, int max_age){
        return current_age/max_age;
    }
}
