package serg.chertkov.evolution.animals;

import serg.chertkov.evolution.limbs.Limb;
import serg.chertkov.evolution.utils.Genes;

import java.util.List;
import java.util.Objects;

/**
 * Created by sergey on 27.02.2016.
 */
public class Animal implements Action {
    private long id;
    private String genes;
    private AnimalProperty property;
    private List<Limb> limbs;
    private String [] cleanGenes;
    private String speciesGen;

    public Animal (String genes, AnimalProperty property){
        this.genes = genes;
        this.cleanGenes = Genes.cleanGenes(genes);
        this.speciesGen = this.speciesGen();
        this.property = property;
    }

    public Animal (Object obj) throws AnimalException {
        this.set(obj.toString());
        this.cleanGenes = Genes.cleanGenes(genes);
        this.speciesGen = this.speciesGen();
    }

    public Animal(){
        try {
            this.set("0=AZ=0-0-0-0-0");
        } catch (AnimalException e) {
            e.printStackTrace();
        }
        this.cleanGenes = Genes.cleanGenes(genes);
        this.speciesGen = this.speciesGen();
    }

    public String getSpeciesGen(){return this.speciesGen;}

    public int countOfGenes(){
        return this.cleanGenes.length;
    }

    public String getCleanGenes(int i){
        return this.cleanGenes[i];
    }

    public String[] getCleanGenes() {return this.cleanGenes;}

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
        return this.genes.hashCode();
    }

    public boolean equals(Object obj){
        if(obj.getClass()==this.getClass())
            return this.equals((Animal)obj);
        return false;
    }

    public boolean equals(Animal obj){
        return this.speciesGen.equals(obj.getSpeciesGen());
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

    private String speciesGen (){
        String speciesGen = "";
        for (int i=0; i<this.countOfGenes(); i++){
            if(this.cleanGenes[i].length()>3){
                speciesGen += this.cleanGenes[i].substring(0,3);
            } else{
                speciesGen += this.cleanGenes[i];
                for(int j=3; j>this.cleanGenes[i].length();j--)
                    speciesGen += ".";
            }
        }
        return speciesGen;
    }
}
