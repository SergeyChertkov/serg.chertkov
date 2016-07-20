package serg.chertkov.evolution.world;

import serg.chertkov.evolution.utils.EvoData;

/**
 * Created by sergey on 12.03.2016.
 */
public class Desert extends Cell {

    public Desert(int x, int y){
        super(World.startNrg);
        type = EvoData.BIOME_DESERT;
        this.x = x;
        this.y = y;
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
