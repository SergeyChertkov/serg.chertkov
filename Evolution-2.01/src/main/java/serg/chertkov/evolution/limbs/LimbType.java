package serg.chertkov.evolution.limbs;

import serg.chertkov.evolution.utils.Genes;

/**
 * Created by Sergii_Chertkov on 7/19/2016.
 */
public class LimbType {
    private static String [] mover;
    private static String [] absorber;
    private static String [] genitals;
    private static String [] reproductor;
    private static String [] ageSensation;
    private static String [] hunger;
    private static String [] scaner;
    private static String [] aggressor;
    private static String [] deffender;
    private static String [] neuron;

    public static final int size = 3;

    public static void generate(){
        mover = new String [30];
        absorber = new String [3];
        genitals = new String [1];
        reproductor = new String [1];
        ageSensation = new String [1];
        hunger = new String [1];
        scaner = new String [4];
        aggressor = new String [1];
        deffender = new String [1];
        neuron = new String [1];

        for (int i=0; i<mover.length; i++)
            mover[i] = generateGen();
        for (int i=0; i<absorber.length; i++)
            absorber[i] = generateGen();
        for (int i=0; i<genitals.length; i++)
            genitals[i] = generateGen();
        for (int i=0; i<reproductor.length; i++)
            reproductor[i] = generateGen();
        for (int i=0; i<ageSensation.length; i++)
            ageSensation[i] = generateGen();
        for (int i=0; i<hunger.length; i++)
            hunger[i] = generateGen();
        for (int i=0; i<scaner.length; i++)
            scaner[i] = generateGen();
        for (int i=0; i<aggressor.length; i++)
            aggressor[i] = generateGen();
        for (int i=0; i<deffender.length; i++)
            deffender[i] = generateGen();
        for (int i=0; i<neuron.length; i++)
            neuron[i] = generateGen();
    }

    private static String generateGen(){
        String result;
        int rand;
        do{
            result = "";
            for(int i=0; i<size; i++) {
                rand = (int) (Math.random() * 23);
                result += Genes.AllGenes.substring(rand, rand + 1);
            }
        }while(ifGenLimbExist(result));
        return result;
    }

    public static String getTypeOfGen(String gen){
        for (int i =0; i<mover.length; i++)
            if(gen.equals(mover[i])) return "mover"+i;
        for (int i =0; i<absorber.length; i++)
            if(gen.equals(absorber[i])) return "absorber"+i;
        for (int i =0; i<genitals.length; i++)
            if(gen.equals(genitals[i])) return "genitals"+i;
        for (int i =0; i<reproductor.length; i++)
            if(gen.equals(reproductor[i])) return "reproductor"+i;
        for (int i =0; i<ageSensation.length; i++)
            if(gen.equals(ageSensation[i])) return "ageSensation"+i;
        for (int i =0; i<hunger.length; i++)
            if(gen.equals(hunger[i])) return "hunger"+i;
        for (int i =0; i<scaner.length; i++)
            if(gen.equals(scaner[i])) return "scaner"+i;
        for (int i =0; i<aggressor.length; i++)
            if(gen.equals(aggressor[i])) return "aggressor"+i;
        for (int i =0; i<deffender.length; i++)
            if(gen.equals(deffender[i])) return "deffender"+i;
        for (int i =0; i<neuron.length; i++)
            if(gen.equals(neuron[i])) return "neuron"+i;
        return "empty";
    }

    public static boolean ifGenLimbExist(String gen){
        if(getTypeOfGen(gen).equals("empty"))
            return false;
        else return true;
    }

    public static String getMover(int i){
        if (i<mover.length) return mover[i];
        else return null;
    }

    public static String getAbsorber(int i){
        if (i<absorber.length) return absorber[i];
        else return null;
    }

    public static String getGenitals(int i){
        if (i<genitals.length) return genitals[i];
        else return null;
    }

    public static String getReproductor(int i){
        if (i<reproductor.length) return reproductor[i];
        else return null;
    }

    public static String getAgeSensation(int i){
        if (i<ageSensation.length) return ageSensation[i];
        else return null;
    }

    public static String getHunger(int i){
        if (i<hunger.length) return hunger[i];
        else return null;
    }

    public static String getScaner(int i){
        if (i<scaner.length) return scaner[i];
        else return null;
    }

    public static String getAggressor(int i){
        if (i<aggressor.length) return aggressor[i];
        else return null;
    }

    public static String getDeffender(int i){
        if (i<deffender.length) return deffender[i];
        else return null;
    }

    public static String getNeuron(int i){
        if (i<neuron.length) return neuron[i];
        else return null;
    }
}
