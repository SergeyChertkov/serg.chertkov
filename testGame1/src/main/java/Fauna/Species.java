package Fauna;

import java.util.ArrayList;

/**
 * Created by sergey on 30.05.2016.
 */
public class Species {
    private ArrayList<Specie> species;

    public Species(){
        species = new ArrayList<Specie>();
    }

    public void add (String genes){
        Specie sp_tmp = new Specie(genes);
        boolean add = false;
        for (int i=0; i<size(); i++){
            if(species.get(i).genes.equals(genes)){
                species.get(i).count++;
                add = true;
                break;
            }

        }
        if(!add)species.add(sp_tmp);
    }

    public int size() {
        return species.size();
    }

    public int getCount(int index){
        return species.get(index).count;
    }

    public String getGenes(int index){
        return species.get(index).genes;
    }

    private class Specie{
        public String genes = "";
        public int count = 0;

        public Specie(String genes){
            this.genes = genes;
            count = 1;
        }
    }
}
