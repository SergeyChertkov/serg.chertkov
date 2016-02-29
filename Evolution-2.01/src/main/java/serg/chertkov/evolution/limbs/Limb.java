package serg.chertkov.evolution.limbs;


/**
 * Created by sergey on 27.02.2016.
 */
public abstract class Limb {
    public boolean status;

    public void setInput(double[] input){}

    public double[] getImpulses(){
        return new double[]{0};
    }

    public int getAction(){
        return Action.SLEEP;
    }
}
