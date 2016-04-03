package serg.chertkov.evolution.limbs;


/**
 * A class describes the basic properties and methods of limb
 *
 * Created by sergey on 27.02.2016.
 */
public abstract class Limb {
    /**
     * property of limb
     */
    protected int property;

    /**
     * coefficient[] - coefficients that determine the properties and characteristics of limb
     */
    protected double coefficient[];

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
     * Method return values of coefficients that determine the properties and characteristics of limb
     * @return coefficient - double[]
     */
    public double[] getCoefficients(){
        return this.coefficient;
    }

    /**
     * Method return value of impulse that comes from the limb
     * @return impulse - double
     */
    public double getImpulse(){
        return impulse;
    }

    /**
     * Method return level of structure in the animal
     * @return level - int
     */
    public int getLevel(){
        return this.level;
    }
}
