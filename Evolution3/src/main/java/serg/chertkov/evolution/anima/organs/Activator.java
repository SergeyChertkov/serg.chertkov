package serg.chertkov.evolution.anima.organs;

import serg.chertkov.evolution.anima.genes.Chromosome;

@SuppressWarnings("unused")
public class Activator extends Organ {
    public Activator(char[] genes) {
        super(genes);
    }

    @Override
    void setDefaultTypes() {
        super.defaultTypes = new char[]{};
    }
}
