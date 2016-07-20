package serg.chertkov.evolution.world;

import serg.chertkov.evolution.utils.EvoData;

/**
 * Created by sergey on 12.03.2016.
 */
public class Plain extends Cell{

    public Plain(int x, int y){
        super(World.startNrg);
        type = EvoData.BIOME_PLAIN;
        this.x = x;
        this.y = y;
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
