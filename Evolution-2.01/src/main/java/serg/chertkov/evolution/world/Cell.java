package serg.chertkov.evolution.world;

import serg.chertkov.evolution.EvoData;

/**
 * Created by sergey on 12.03.2016.
 */
public class Cell {
    protected int type;
    protected int max;
    protected int growth;
    protected int nrg;
    protected int corpse;
    protected int animal;
    protected int volume;
    protected int x;
    protected int y;

    public Cell(int nrg){
        type = 0;
        this.nrg = nrg;
        corpse = 0;
        animal = 0;
        volume = 0;
    }

    public int getData(int dataType){
        switch(dataType){
            case EvoData.CELLS_BIOME: return type;
            case EvoData.CELLS_NRG: return nrg;
            case EvoData.CELLS_CORPSE: return corpse;
            case EvoData.CELLS_ANIMAL: return animal;
            case EvoData.CELLS_VOLUME: return volume;
            default: return 0;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNrg() {
        return nrg;
    }

    public void setNrg(int nrg) {
        this.nrg = nrg;
    }

    public int getCorpse() {
        return corpse;
    }

    public void setCorpse(int corpse) {
        this.corpse = corpse;
    }

    public int getAnimal() {
        return animal;
    }

    public void setAnimal(int animal) {
        this.animal = animal;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turn(){}{

    }

    public String toString(){
        return "coordinates = (" + String.valueOf(x) +
                ","+ String.valueOf(y) +")"+
                "; type = " + String.valueOf(type) +
                "; nrg = " + String.valueOf(nrg) +
                "; corpse = " + String.valueOf(corpse) +
                "; animal = " + String.valueOf(animal) +
                "; volume = " + String.valueOf(volume);
    }

}
