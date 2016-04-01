package serg.chertkov.evolution.world;

/**
 * Created by sergey on 12.03.2016.
 */
public abstract class Cell {
    protected int type;
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

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void turn(){};

    public String toString(){
        return "type = " + String.valueOf(type) +
                "; nrg = " + String.valueOf(nrg) +
                "; corpse = " + String.valueOf(corpse) +
                "; animal = " + String.valueOf(animal);
    }

}
