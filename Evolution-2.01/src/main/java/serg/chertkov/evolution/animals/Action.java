package serg.chertkov.evolution.animals;

import serg.chertkov.evolution.limbs.Limb;

import java.util.List;

/**
 * Created by sergey on 27.02.2016.
 */
public interface Action {

    void action();

    Animal born ();

    void sleep();

    void eat();

    boolean reproduction();

    boolean copulation();

    boolean moveUp();

    boolean moveDown();

    boolean moveLeft();

    boolean moveRight();

    void death();

}
