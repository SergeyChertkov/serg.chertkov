package serg.chertkov.evolution.world;

/**
 * Created by sergey on 12.03.2016.
 */
public class Desert extends Cell {

    public Desert(){
        super(World.startNrg);
        type = 11;
    }

    @Override
    public void turn(){
        int max = 100;
        if (nrg > 0 && nrg < max)
            nrg += Math.random() > 0.9 ? 1 : 0;
        if (nrg > max)
            nrg = max;
    }
}
