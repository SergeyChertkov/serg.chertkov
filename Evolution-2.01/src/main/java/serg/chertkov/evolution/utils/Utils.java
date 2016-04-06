package serg.chertkov.evolution.utils;

import org.apache.commons.lang.ArrayUtils;
import serg.chertkov.evolution.world.World;

/**
 * Created by sergey on 12.03.2016.
 */
public class Utils {
    public static int maxIndex(int a[]){
        int max = 0;
        for(int i=1; i< a.length; i++)
            if(a[max]<a[i]) max = i;
        return max;
    }

    public static double neuronFunction(int number, double impulse, double coefficient_1, double coefficient_2){
        double result;
        switch (number){
            case 1: result = impulse + coefficient_1; break;
            case 2: result = impulse * coefficient_1; break;
            case 3: result = impulse * coefficient_1 + coefficient_2; break;
            case 4: result = 1/impulse + coefficient_1; break;
            case 5: result = coefficient_1/impulse; break;
            case 6: result = coefficient_1/impulse + coefficient_2; break;
            case 7: result = Math.pow(impulse,2) + coefficient_1; break;
            case 8: result = Math.pow(impulse,coefficient_1); break;
            case 9: result = Math.pow(impulse,coefficient_1) + coefficient_2; break;
            case 10: result = Math.sin(impulse) + coefficient_1; break;
            case 11: result = Math.sin(impulse) * coefficient_1; break;
            case 12: result = Math.sin(impulse) * coefficient_1 + coefficient_2; break;
            case 13: result = Math.tan(impulse) + coefficient_1; break;
            case 14: result = Math.tan(impulse) * coefficient_1; break;
            case 15: result = Math.tan(impulse) * coefficient_1 + coefficient_2; break;
            case 16: result = Math.random() * coefficient_1 + coefficient_2; break;
            case 17: result = coefficient_1 / Math.random() + coefficient_2; break;
            case 18: result = Math.pow(Math.random(),coefficient_1) + coefficient_2; break;
            case 19: result = Math.sin(Math.random()) * coefficient_1 + coefficient_2; break;
            case 20: result = Math.tan(Math.random()) * coefficient_1 + coefficient_2; break;
            default: result = 0;
        }
        return result;
    }

    public static double[] generateCoefficient(int count, double[]coefficient){
        double[] a = coefficient;
        while(a.length<count)
            a = ArrayUtils.addAll(a,coefficient);
        while(a.length>count)
            a = ArrayUtils.remove(a,a.length-1);
        return a;
    }

    /**
     * Method of making the offset to the coordinates
     * and to check the values were within the limits.
     *
     * @param current_xy
     * @param offset_xy
     * @return
     */
    public static int offsetCoordinates (int current_xy, int offset_xy){
        int result = current_xy+offset_xy;
        if(result >= World.size())
            result -= World.size();
        if(result < 0)
            result += World.size();
        return result;
    }

}
