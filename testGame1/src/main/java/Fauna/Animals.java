package Fauna;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 30.05.2016.
 */
public class Animals {
    private static ArrayList<Animal> animals = new ArrayList<Animal>();

    public static void add(Animal animal) {
        if(animal!=null)
            animals.add(animal);
    }

    public static void add(String genes){
        Animal animal = Animal.animalGenerator(genes);
        add(animal);
    }

    public static void add(){
        Animal animal = Animal.animalGenerator();
        add(animal);
    }

    public static Animal get(int index) {
        return animals.get(index);
    }

    public static void remove(Object animal) {
        animals.remove(animal);

    }

    public static int size() {
        return animals.size();
    }

    public static void turn(){
        for (int i=0; i< size(); i++) {
            animals.get(i).turn();
        }
    }

    public static void draw(Graphics g){
        for (int i=0; i< size(); i++) {
            animals.get(i).draw(g);
        }
    }

    public static void printSpecies(){
        Species species = new Species();
        for(int i=0; i< size(); i++)
            species.add(animals.get(i).getGenes());
        for(int i=0; i<species.size(); i++){
            if(species.getCount(i)>10)
                System.out.println("Species #" + i + ": " + species.getCount(i) + "; genes: " + species.getGenes(i));
        }

    }

}
