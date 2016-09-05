package serg.chertkov.evolution.utils;

import java.util.ArrayList;

/**
 * Created by Sergii_Chertkov on 6/2/2016.
 */
public class Genes {
    public static final String AllGenes = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final char START_CODON = 'A';
    public static final char [] END_CODON = {'X','Y','Z'};
    public static final int MAX_LENGHT = 100000;

    public static String[] cleanGenes (String genes){
        int index_end_codon;
        ArrayList<String> gen = new ArrayList<String>();
        for(int i=0; i<genes.length() && genes.indexOf("A")>=0; i++){
            genes = genes.substring(genes.indexOf("A")+1,genes.length());
            index_end_codon = index_end_codon(genes);
            if(index_end_codon == -1){
                gen.add(genes);
                i = genes.length();
            }
            else{
                gen.add(genes.substring(0,index_end_codon));
                i=0;
            }
        }
        String [] result = new String[gen.size()];
        for(int i=0; i<gen.size(); i++)
            result[i] = gen.get(i);
        return result;
    }

    private static int index_end_codon (String genes){
        int result;
        int [] index_end_codon = {0, 0, 0};
        for(int j=0; j<3; j++){
            index_end_codon[j] = genes.indexOf(END_CODON[j]);
            if(index_end_codon[j]<=0)
                index_end_codon[j] = 2147483647;
        }
        result = Utils.minIndex(index_end_codon);
        if(index_end_codon[result]== 2147483647)
            return -1;
        else return index_end_codon[result];
    }

    public static int transformationGenes (String genes){
        int result = 0;
        int tmp;
        if(genes.length()>0){
            char [] gen = genes.toCharArray();
            for(int i=0; i<gen.length; i++){
                switch(gen[i]){
                    case 'B': tmp = 1; break;
                    case 'C': tmp = 2; break;
                    case 'D': tmp = 3; break;
                    case 'E': tmp = 4; break;
                    case 'F': tmp = 5; break;
                    case 'G': tmp = 6; break;
                    case 'H': tmp = 7; break;
                    case 'I': tmp = 8; break;
                    case 'J': tmp = 9; break;
                    case 'K': tmp = 10; break;
                    case 'L': tmp = 11; break;
                    case 'M': tmp = 12; break;
                    case 'N': tmp = 13; break;
                    case 'O': tmp = 14; break;
                    case 'P': tmp = 15; break;
                    case 'Q': tmp = 16; break;
                    case 'R': tmp = 17; break;
                    case 'S': tmp = 18; break;
                    case 'T': tmp = 19; break;
                    case 'U': tmp = 10; break;
                    case 'V': tmp = 21; break;
                    case 'W': tmp = 22; break;
                    default: tmp = 0; break;
                }
                result += Math.pow(23,gen.length-1-i)*tmp;
            }
        }
        return result;
    }

    public static double [] generateCoefficients (String gen){
        if (gen.length()<2)
            return new double [] {0.0};
        double [] result = new double[gen.length()/2];
        for (int i=0; i<result.length; i++)
            result[i] = Utils.transformationCoefficient(transformationGenes(gen.substring(2*i,2*i+2)));
        return result;
    }
}
