package serg.chertkov.evolution.anima;

import serg.chertkov.evolution.world.WorldFunction;

@SuppressWarnings("WeakerAccess")
public class Animal implements AnimalFunction {
    WorldFunction world;
    /**
     * 0 - up
     * 1 - right
     * 2 - down
     * 3 - left
     **/
    char position = (char) (Math.random() * 4);
    int x, y;

    @Override
    public Animal setWorld(WorldFunction world) {
        this.world = world;
        return this;
    }

    @Override
    public Animal turnLeft() {
        position = (char) ((position == 0) ? 3 : (position - 1));
        return this;
    }

    @Override
    public Animal turnRight() {
        position = (char) ((position == 3) ? 0 : (position + 1));
        return this;
    }

    @Override
    public Animal turnBack() {
        position = (char) ((position < 2) ? (position + 2) : (position - 2));
        return this;
    }

    @Override
    public Animal move() {
        switch (position) {
            case 0:
                if(world.getCell(x,y-1).isEmpty()){
                    world.getCell(x,y).setAnimal(null);
                    y-=1;
                    world.getCell(x,y).setAnimal(this);
                }
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        return this;
    }

    @Override
    public Animal jump() {
        return this;
    }

    @Override
    public Animal pairing() {
        return this;
    }

    @Override
    public Animal attack() {
        return this;
    }

    @Override
    public Animal eat() {
        return this;
    }

    @Override
    public Animal sleep() {
        return this;
    }

    @Override
    public Animal reproduce() {
        return this;
    }
}
