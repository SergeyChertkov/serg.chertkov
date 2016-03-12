package serg.chertkov.evolution.world;

/**
 * Created by sergey on 12.03.2016.
 */
public class Ocean extends Cell {

    public Ocean(){
        super(World.startNrg);
        type = 1;
    }

    @Override
    public void turn(){
        int max = 1000;
        if (nrg > 0 && nrg < max)
            nrg += (int)(10*Math.random()*nrg/100) + 1;
        if (nrg > max)
            nrg = max;
    }
}
