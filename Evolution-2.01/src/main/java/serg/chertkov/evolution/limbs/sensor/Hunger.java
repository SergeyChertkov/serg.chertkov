package serg.chertkov.evolution.limbs.sensor;

import serg.chertkov.evolution.limbs.Sensor;

/**
 * Created by sergey on 27.02.2016.
 */
public class Hunger extends Sensor {
    public Hunger(double []coefficient) {
        super(coefficient);
    }

    @Override
    public double dataCatch(int current_nrg, int max_nrg){
        return current_nrg/max_nrg;
    }
}
