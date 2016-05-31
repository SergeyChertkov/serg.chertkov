package Flora;

/**
 * Created by sergey on 30.05.2016.
 */
public class Cell {
    private int nrg;
    private boolean animal;
    private int maxNrg;//0-1000
    private double growNrg;//0-1

    public Cell(int nrg, int max, double grow, boolean animal) {
        this.nrg = nrg;
        this.animal = animal;
        this.maxNrg = max;
        this.growNrg = grow;
        if(this.nrg>maxNrg)
            this.nrg = maxNrg;
    }

    public int eat(int nrg) {
        int result = nrg;
        if (nrg >= this.nrg) {
            result = this.nrg;
            this.nrg = 0;
        } else
            this.nrg -= nrg;
        return result;
    }

    public void animalComes() {
        this.animal = true;
    }

    public void animalLeaves() {
        this.animal = false;
    }

    public int getNrg(){
        return nrg;
    }

    public void turn(){
        if(nrg<maxNrg && !ifAnimal())
            nrg+=Math.random()>(1-growNrg)?1:0;
    }

    public boolean ifAnimal() {
        return animal;
    }
}
