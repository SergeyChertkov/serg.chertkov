package serg.chertkov.evolution.limbs;


/**
 * Created by sergey on 27.02.2016.
 */
public abstract class Limb {
    /**
     * coefficient[] - coefficients that determine the properties and characteristics of limb
     */
    public double coefficient[];

    /**
     * impulse - impulse that comes from the limb
     */
    protected double impulse;

    /**
     * level - level of structure in the animal
     */
    protected int level;

    /**
     * Method accepts incoming data and generates the outgoing impulse
     * @param input - double[]
     */
    public void setInput(double[] input){
        impulse = 0;
    }

    /**
     * Method return value of impulse
     * @return impulse - double
     */
    public double getImpulse(){
        return impulse;
    }
}
