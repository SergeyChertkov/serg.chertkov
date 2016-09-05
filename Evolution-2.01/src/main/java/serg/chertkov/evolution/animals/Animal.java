package serg.chertkov.evolution.animals;

import serg.chertkov.evolution.limbs.Limb;
import serg.chertkov.evolution.utils.Genes;

import java.util.List;

/**
 * Created by sergey on 27.02.2016.
 */
public class Animal implements Action {
    private long id;
    private String genes;
    private AnimalProperty property;
    private List<Limb> limbs;
    private String [] cleanGenes;

    public Animal (String genes, AnimalProperty property){
        this.genes = genes;
        this.cleanGenes = Genes.cleanGenes(genes);
        this.property = property;
    }

    public Animal (String animal) throws AnimalException {
        this.set(animal);
        this.cleanGenes = Genes.cleanGenes(genes);
    }

    public Animal(){
        try {
            this.set("0=AZ=0-0-0-0-0");
        } catch (AnimalException e) {
            e.printStackTrace();
        }
        this.cleanGenes = Genes.cleanGenes(genes);
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

    public long getId() {
        return id;
    }

    public void set (String animal) throws AnimalException {
        String []prop = animal.split("=");
        if(prop.length<3)
            throw new AnimalException("Don't enough arguments (" + prop.length +
                    ") to convert String to Animal.");
        this.id = Integer.parseInt(prop[0]);
        this.genes = prop[1];
        this.property = new AnimalProperty(prop[2]);
    }

    public String toString(){
        String result = "";
        Long tmp = this.id;
        result += tmp.toString() +"=";
        result += this.genes +"=";
        result += property.toString();
        return result;
    }
}
