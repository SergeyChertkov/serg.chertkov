package serg.chertkov.evolution.limbs;

import org.apache.commons.lang.ArrayUtils;
import serg.chertkov.evolution.utils.Utils;

import static java.lang.Math.pow;

/**
 * Created by sergey on 27.02.2016.
 */
public class Sensor extends Limb {

    /*types of scanner*/
    public static final int BIOM_SCANER = 0;
    public static final int NRG_SCANER = 1;
    public static final int CORPSE_SCANER = 2;
    public static final int ANIMAL_SCANER = 3;
    public static final int VOLUME_SCANER = 4;

    public Sensor(double []coefficient){
        this.level = 1;
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
