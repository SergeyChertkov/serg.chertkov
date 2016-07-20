package serg.chertkov.evolution.limbs;

import serg.chertkov.evolution.limbs.activator.*;
import serg.chertkov.evolution.limbs.passive.*;
import serg.chertkov.evolution.limbs.sensor.*;
import serg.chertkov.evolution.utils.Genes;

/**
 * Created by Sergii_Chertkov on 7/18/2016.
 */
public class LimbFactory {
    private LimbFactory(){}

    public static Limb create(String genes){
        Limb result = null;
        String type = LimbType.getTypeOfGen(genes);
        type = type.substring(0,type.indexOf('_')>0?type.indexOf('_'):type.length());
        switch(type){
            case "mover": result = new Mover(Genes.generateCoefficients(genes.substring(2,genes.length()))); break;
            case "absorber": result = new Absorber(Genes.generateCoefficients(genes.substring(2,genes.length()))); break;
            case "genitals": result = new Genitals(Genes.generateCoefficients(genes.substring(2,genes.length()))); break;
            case "reproductor": result = new Reproductor(Genes.generateCoefficients(genes.substring(2,genes.length()))); break;
            case "ageSensation": result = new AgeSensation(Genes.generateCoefficients(genes.substring(2,genes.length()))); break;
            case "hunger": result = new Hunger(Genes.generateCoefficients(genes.substring(2,genes.length()))); break;
            case "scanner": result = new Scanner(Genes.generateCoefficients(genes.substring(2,genes.length()))); break;
            case "aggressor": result = new Aggressor(Genes.generateCoefficients(genes.substring(2,genes.length()))); break;
            case "deffender": result = new Deffender(Genes.generateCoefficients(genes.substring(2,genes.length()))); break;
            case "neuron": result = new Neuron(Genes.generateCoefficients(genes.substring(2,genes.length()))); break;
            case "empty": result = new Empty();
        }
        return result;
    }
}
