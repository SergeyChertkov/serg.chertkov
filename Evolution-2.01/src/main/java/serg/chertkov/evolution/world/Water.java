package serg.chertkov.evolution.world;

/**
 * Created by sergey on 12.03.2016.
 */
public class Water extends Cell {

    public Water(int x, int y){
        super(World.startNrg);
        type = 2;
        this.x = x;
        this.y = y;
    }

    @Override
    public void turn(){
        int max = 3000;
        if (nrg > 0 && nrg < max)
            nrg += (int)(10*Math.random()*nrg/100) + 1;
        if (nrg > max)
            nrg = max;
    }
}
