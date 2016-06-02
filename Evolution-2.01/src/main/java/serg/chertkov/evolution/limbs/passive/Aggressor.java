package serg.chertkov.evolution.limbs.passive;

import serg.chertkov.evolution.limbs.Limb;

/**
 * Created by sergey on 27.02.2016.
 */
public class Aggressor extends Limb {
    public Aggressor(double []coefficient) {
        this.level = -1;
        this.property = (int) coefficient[0];
    }
}
