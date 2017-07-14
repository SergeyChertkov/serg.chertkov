package serg.chertkov.evolution.anima.organs;

import java.util.Arrays;

import static serg.chertkov.evolution.anima.organs.OrganType.*;

@SuppressWarnings("unused")
public class Neuron extends Organ {
    private double[] weight;
    private double outputImpulse = 0;

    public Neuron(char[] genes) {
        super(genes);
        weight = new double[genes.length - 3];
        for (int i = 0; i < weight.length; i++) {
            weight[i] = genes[i + 3] - 128;
        }
    }

    @Override
    void setDefaultTypes() {
        super.defaultTypes = new char[]{NEURON};
    }

    @Override
    public double action(double[] impulse) {
        outputImpulse = 0;
        int size = weight.length > impulse.length ? impulse.length : weight.length;
        for (int i = 0; i < size; i++) {
            outputImpulse += weight[i] * impulse[i];
        }
        status = true;
        return getOutputImpulse();
    }

    public double getOutputImpulse() {
        if (status) {
            return outputImpulse;
        } else {
            throw new OrganException("No impulses");
        }
    }
}
