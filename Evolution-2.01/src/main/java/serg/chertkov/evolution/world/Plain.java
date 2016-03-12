package serg.chertkov.evolution.world;

/**
 * Created by sergey on 12.03.2016.
 */
public class Plain extends Cell{

    public Plain(){
        super(World.startNrg);
        type = 12;
    }

    @Override
    public void turn(){
        int max = 2000;
        if (nrg > 0 && nrg < max)
            nrg += (int)(5*Math.random()*nrg/100) + 1;
        if (nrg > max)
            nrg = max;
    }
}
