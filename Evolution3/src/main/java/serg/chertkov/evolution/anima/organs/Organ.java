package serg.chertkov.evolution.anima.organs;

import static serg.chertkov.evolution.Utils.arrayContains;

@SuppressWarnings("unused")
public abstract class Organ implements OrganFunction {
    char[] defaultTypes;
    char type;
    double nrgForAction;
    double nrgForSleep;
    double health;
    boolean status;
    char[] genes;

//    public static Organ factory(Chromosome genes) {
//        Organ currentOrgan = new Organ((char) 0);
//        return currentOrgan;
//    }

    public Organ(char[] genes) {
        this.genes = genes;
        type = genes[0];
        health = genes[1];
        nrgForAction = (1 + genes[2]) / 100;
        nrgForSleep = nrgForAction / 10;
        setDefaultTypes();
        if (!arrayContains(defaultTypes,type)) {
            throw new OrganException("Can not create [" + this.getClass() + "] with type '" + (int) type + "'.");
        }
    }

    abstract void setDefaultTypes();

    private Organ(char type) {
        this.type = type;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void damage(double hit) {
        if (isAlive()) {
            health -= hit;
        }
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public double action(double[] impulse) {
        if (isAlive()) {
            status = true;
        }
        return 0;
    }

    @Override
    public void endOfTurn() {
        status = false;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

}
