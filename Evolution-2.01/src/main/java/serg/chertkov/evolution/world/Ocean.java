package serg.chertkov.evolution.world;

import serg.chertkov.evolution.utils.EvoData;

/**
 * Created by sergey on 12.03.2016.
 */
public class Ocean extends Cell {

    public Ocean(int x, int y){
        super(World.startNrg);
        type = EvoData.BIOME_OCEAN;
        this.x = x;
        this.y = y;
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
