package serg.chertkov.evolution.utils;

import org.apache.commons.lang.ArrayUtils;

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

    public static double neuronFunction(int number, double impulse, double[] coefficient){
        double result;
        switch (number){
            case 1: result = impulse + coefficient[0]; break;
            case 2: result = impulse * coefficient[0]; break;
            case 3: result = impulse * coefficient[0] + coefficient[1]; break;
            case 4: result = 1/impulse + coefficient[0]; break;
            case 5: result = coefficient[0]/impulse; break;
            case 6: result = coefficient[0]/impulse + coefficient[1]; break;
            case 7: result = Math.pow(impulse,2) + coefficient[0]; break;
            case 8: result = Math.pow(impulse,coefficient[0]); break;
            case 9: result = Math.pow(impulse,coefficient[0]) + coefficient[1]; break;
            case 10: result = Math.sin(impulse + coefficient[0]); break;
            case 11: result = Math.sin(impulse * coefficient[0]); break;
            case 12: result = Math.sin(impulse * coefficient[0] + coefficient[1]); break;
            case 13: result = Math.tan(impulse + coefficient[0]); break;
            case 14: result = Math.tan(impulse * coefficient[0]); break;
            case 15: result = Math.tan(impulse * coefficient[0] + coefficient[1]); break;
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
}
