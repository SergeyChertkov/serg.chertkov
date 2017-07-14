package serg.chertkov.evolution.anima.organs;

import static serg.chertkov.evolution.anima.organs.OrganType.*;

@SuppressWarnings("unused")
public class Feature extends Organ {
    public Feature(char[] genes) {
        super(genes);
    }

    @Override
    void setDefaultTypes() {
        super.defaultTypes = new char[]{};
    }
}
