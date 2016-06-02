package serg.chertkov.evolution.limbs;

import org.apache.commons.lang.ArrayUtils;
import serg.chertkov.evolution.utils.Utils;

import static java.lang.Math.pow;

/**
 * Created by sergey on 27.02.2016.
 */
public class Sensor extends Limb {

    public Sensor(double []coefficient){
        this.level = 0;
        this.property = (int) coefficient[0];
        this.coefficient = ArrayUtils.remove(coefficient, 0);
    }

    /**
     * Method catching outside/inside data and transforming it to impulse
     * @return
     */
    public double dataCatch(int a, int b){
        return 0;
    }

    @Override
    public void setInput(double[] input){
        double inp = dataCatch(0,0);
        impulse = Utils.neuronFunction((int)(coefficient[0]%20+1),inp, coefficient[1], coefficient[2]);
    }

}
