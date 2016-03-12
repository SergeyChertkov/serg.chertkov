package serg.chertkov.evolution.world;

/**
 * Created by sergey on 12.03.2016.
 */
public class Forest extends Cell {

    public Forest(){
        super(World.startNrg);
        type = 13;
    }

    @Override
    public void turn(){
        int max = 5000;
        if (nrg > 0 && nrg < max)
            nrg += (int)(5*Math.random()*nrg/100) + 1;
        if (nrg > max)
            nrg = max;
    }
}
