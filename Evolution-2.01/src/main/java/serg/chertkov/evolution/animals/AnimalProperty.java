package serg.chertkov.evolution.animals;

import java.util.IllegalFormatException;

/**
 * Created by Sergii_Chertkov on 4/1/2016.
 */
public class AnimalProperty {
    public int x;
    public int y;
    public short nrg;
    public short age;
    public byte position; // 4 posible positions

    public AnimalProperty(int x, int y, short nrg, short age, byte position){
        this.x = x;
        this.y = y;
        this.nrg = nrg;
        this.age = age;
        this.position = position;
    }

    public AnimalProperty(String property) throws AnimalException {
        this.set(property);
    }

    public void set(AnimalProperty property){
        this.x = property.x;
        this.y = property.y;
        this.nrg = property.nrg;
        this.age = property.age;
        this.position = property.position;
    }

    public void set(String property) throws AnimalException {
        String []prop = property.split("-");
        if(prop.length<5)
            throw new AnimalException("Don't enough arguments (" + prop.length +
                    ") to convert String to AnimalProperty.");
        this.x = Integer.parseInt(prop[0]);
        this.y = Integer.parseInt(prop[1]);
        this.nrg = (short) Integer.parseInt(prop[2]);
        this.age = (short) Integer.parseInt(prop[3]);
        this.position = (byte) Integer.parseInt(prop[4]);
    }

    public String toString(){
        String result = "";
        Integer tmp = this.x;
        result += tmp.toString() +"-";
        tmp = this.y;
        result += tmp.toString() +"-";
        tmp = (int) this.nrg;
        result += tmp.toString() +"-";
        tmp = (int) this.age;
        result += tmp.toString() +"-";
        tmp = (int) this.position;
        result += tmp.toString();
        return result;
    }
}
