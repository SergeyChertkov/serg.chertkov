package serg.chertkov.evolution.anima;

import serg.chertkov.evolution.world.WorldFunction;

@SuppressWarnings("unused")
public interface AnimalFunction {
    Animal setWorld(WorldFunction world);

    Animal turnLeft();

    Animal turnRight();

    Animal turnBack();

    Animal move();

    Animal jump();

    Animal pairing();

    Animal attack();

    Animal eat();

    Animal sleep();

    Animal reproduce();
}
