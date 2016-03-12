package serg.chertkov.evolution.utils;

/**
 * Created by sergey on 12.03.2016.
 */
public class Utils {
    public static int MaxIndex(int a[]){
        int max = 0;
        for(int i=1; i< a.length; i++)
            if(a[max]<a[i]) max = i;
        return max;
    }
}
