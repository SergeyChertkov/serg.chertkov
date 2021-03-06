package serg.chertkov.evolution.limbs;

import org.apache.commons.lang.ArrayUtils;
import serg.chertkov.evolution.limbs.utils.Action;
import serg.chertkov.evolution.utils.Utils;

/**
 * Created by sergey on 27.02.2016.
 */
public class Activator extends Limb {
    protected int currentAction;
    protected int action = Action.SLEEP;
    protected double takeNrgForAction;

    public Activator(double []coefficient){
        this.action = Action.SLEEP;
        this.currentAction = Action.SLEEP;
        this.level = 0;
        this.property = (int) coefficient[0];
        this.coefficient = ArrayUtils.remove(coefficient, 0);
    }

    public void setInput(double[] input){
        double result = 0;
        if(coefficient.length>0) {
            double [] coef = Utils.generateCoefficient(input.length+1, coefficient);
            for (int i = 0; i < input.length; i++) {
                result += coef[i]*input[i];
            }
            result += coef[input.length];
        }
        if (result>0)
            currentAction = action;
    }
}
