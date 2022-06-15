package sort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Neuron {
    static List<Integer> k = new ArrayList<>();

    public static void main(String... args) {
        List<Integer> inputs = new ArrayList<>();
        for (Integer i = 0; i < 50; i++) {
            inputs.add((int) (Math.random() * 100));
            k.add((int) (Math.random() * 100));
        }
        Integer countOfNeurons = 100;
        Integer countOfAnimals = 10000;// 1M = 30 sec; 100K = 3 sec

        long start = new Date().getTime();
        for (Integer i = 0; i < countOfAnimals; i++) {
            for (Integer j = 0; j < countOfNeurons; j++) {
                generateOutputs(inputs);
            }
        }
        long end = new Date().getTime();
        System.out.println((end - start) + "ms");
    }

    static Integer generateOutputs(List<Integer> inputs) {
        Integer result = 0;
        for (Integer i = 0; i < inputs.size(); i++) {
            result += inputs.get(i) * k.get(i);
        }
        return 0;
    }
}
