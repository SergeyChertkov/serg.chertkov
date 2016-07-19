package serg.chertkov.evolution.animals;

import serg.chertkov.evolution.limbs.Limb;
import serg.chertkov.evolution.utils.Genes;

import java.util.List;

/**
 * Created by sergey on 27.02.2016.
 */
public class Animal implements Action {
    private AnimalProperty property;
    private List<Limb> limbs;
    private String genes;
    private String [] cleanGenes;

    public Animal (String genes, AnimalProperty property){
        this.genes = genes;
        this.cleanGenes = Genes.cleanGenes(genes);
        this.property = property;
    }

    public int countOfGenes(){
        return this.cleanGenes.length;
    }

    public String getCleanGenes(int i){
        return this.cleanGenes[i];
    }

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

    public int hashCode(){
        int result = 0;
        for(String gen: this.cleanGenes){
           result += gen.hashCode();
        }
        return result;
    }

    public boolean equals(Object obj){
        if(obj.getClass()==this.getClass())
            return obj.equals(this);
        return false;
    }

    public boolean equals(Animal obj){
        if(obj.countOfGenes()==this.countOfGenes()){
            for(int i=0; i<this.countOfGenes(); i++)
                if(this.cleanGenes[i]!=obj.getCleanGenes(i))
                    return false;
            return true;
        }
        else return false;
    }

}
