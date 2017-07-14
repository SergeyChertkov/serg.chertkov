package serg.chertkov.evolution.world;

import static serg.chertkov.evolution.world.CellsType.*;

public class Cell {
    char type;
    double energy = 0;
    double meat = 0;

    public Cell(char type, double energy, double meat) {
        this.type = type;
        this.energy = energy;
        this.meat = meat;
    }

    public double eatEnergy(double nrg) {
        double result = 0;
        if (nrg > energy) {
            result = energy;
            energy = 0;
        } else {
            result = nrg;
            energy -= nrg;
        }
        return result;
    }

    public double eatMeat(double mt) {
        double result = 0;
        if (mt > energy) {
            result = meat;
            meat = 0;
        } else {
            result = mt;
            meat -= mt;
        }
        return result;
    }

    public void endOfTurn() {
        double meat_fall = 0;
        switch (type) {
            case WATER:
                growEnergy(GROW_WATER, MAX_WATER);
                meat_fall = 0.4;
                break;
            case SWAMP:
                growEnergy(GROW_SWAMP, MAX_SWAMP);
                meat_fall = 0.5;
                break;
            case PLANT:
                growEnergy(GROW_PLANT, MAX_PLANT);
                meat_fall = 0.6;
                break;
            case HILLS:
                growEnergy(GROW_HILLS, MAX_HILLS);
                meat_fall = 0.7;
                break;
            case MOUNTS:
                growEnergy(GROW_MOUNTS, MAX_MOUNTS);
                meat_fall = 0.8;
                break;
        }
        meat *= meat_fall;
        meat++;
    }

    private void growEnergy(double grow, double max) {
        energy += Math.random() * grow;
        if (energy >= max) {
            energy = max;
        }
    }


}
