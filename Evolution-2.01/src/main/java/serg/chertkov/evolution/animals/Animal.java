package serg.chertkov.evolution.animals;

import serg.chertkov.evolution.limbs.Limb;

import java.util.List;

/**
 * Created by sergey on 27.02.2016.
 */
public class Animal implements Action {
    private int nrg;
    private int age;
    private int position;
    private List<Limb> limbs;

    public void action(){
        for(int i=0; i<limbs.size(); i++){
            limbs.get(i);
        }
    }

    public Animal born() {
        return null;
    }

    public void sleep() {

    }

    public void eat() {

    }

    public boolean reproduction() {
        return false;
    }

    public boolean copulation() {
        return false;
    }

    public boolean moveUp() {
        return false;
    }

    public boolean moveDown() {
        return false;
    }

    public boolean moveLeft() {
        return false;
    }

    public boolean moveRight() {
        return false;
    }

    public void death() {

    }

}
