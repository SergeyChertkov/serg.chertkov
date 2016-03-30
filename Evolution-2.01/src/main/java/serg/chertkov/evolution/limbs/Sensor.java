package serg.chertkov.evolution.limbs;

import static java.lang.Math.pow;

/**
 * Created by sergey on 27.02.2016.
 */
public class Sensor extends Limb {

    public Sensor(double []coefficient){
        this.level = 1;
        this.coefficient = new double[coefficient.length];
        for (int i=0; i<this.coefficient.length; i++) {
            this.coefficient[i] = coefficient[i];
        }
    }

    public double[] dataCatch(){
        return new double[] {0};
    }

    @Override
    public void setInput(double[] input){
        double[] in = dataCatch();

    }

}
