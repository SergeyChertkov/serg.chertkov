package serg.chertkov.evolution.limbs;

/**
 * Created by sergey on 27.02.2016.
 */
public class Active extends Limb {
    protected  int count;
    protected double[] input;
    protected double[] a;
    protected double[] b;
    protected double[] c;

    public Active(int count){
        this.count = count;
        this.input = new double[this.count];
        this.a = new double[this.count];
        this.b = new double[this.count];
        this.c = new double[this.count];
    }

    public void setInput(double[] input){
        for(int i=0; i<this.count; i++){
            this.input[i] = input[i];
        }
    }
}
