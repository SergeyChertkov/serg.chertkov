package serg.chertkov.evolution.limbs;

import static java.lang.Math.pow;

/**
 * Created by sergey on 27.02.2016.
 */
public class Sensor extends Limb {
    protected  int count;
    protected double[] input;
    protected double[] a;
    protected double[] b;
    protected double[] c;

    public Sensor(int count){
        this.count = count;
        this.input = new double[this.count];
        this.a = new double[this.count];
        this.b = new double[this.count];
        this.c = new double[this.count];
        this.status = true;
    }

    protected double getImpulse(int id){
        if(id<this.count)
            return a[id] * pow(input[id],c[id]) + b[id];
        else return 0;
    }

    public void setInput(double[] input){
        for(int i=0; i<this.count; i++){
            this.input[i] = input[i];
        }
    }

    public double[] getImpulses(){
        double[] output = new double[this.count];
        for(int i=0; i<this.count; i++){
            output[i] = this.getImpulse(i);
        }
        return new double[]{0.0};
    }
}
