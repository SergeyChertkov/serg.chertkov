package serg.chertkov.evolution;

public class Utils {
    public static boolean arrayContains(char[] array, char value) {
        for (char array_value : array) {
            if (array_value == value) {
                return true;
            }
        }
        return false;
    }

}
