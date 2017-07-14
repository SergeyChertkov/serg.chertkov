package serg.chertkov.evolution.anima.genes;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "WeakerAccess"})
public class GenCode {
    private List<Chromosome> chromosome;

    public GenCode(List<Chromosome> chromosome) {
        this.chromosome = chromosome;
    }

    public GenCode(int chromosomeCount) {
        chromosome = new ArrayList<>();
        for (int i = 0; i < chromosomeCount; i++) {
            chromosome.add(new Chromosome());
        }
    }

    public GenCode() {
        this(10);
    }

    public int count() {
        return chromosome.size();
    }

    public int size() {
        final int[] size = {0};
        chromosome.forEach(c -> size[0] += c.size());
        return size[0];
    }

    public void pairing(GenCode anotherGen) {
        if (count() != anotherGen.count()) {
            throw new GenCodeException("Count of chromosomes are different.");
        }
        for (int i = 0; i < count(); i++) {
            if (chromosomesCanBeReplaced(getChromosome(i), anotherGen.getChromosome(i))) {
                if (Math.random() > 0.5) {
                    setChromosome(i, anotherGen.getChromosome(i));
                }
                if (Math.random() > 0.5) {
                    anotherGen.setChromosome(i, getChromosome(i));
                }
            }
        }
    }

    private static boolean chromosomesCanBeReplaced(Chromosome c1, Chromosome c2) {
        int delta = 5;
        return c1.size() > c2.size() - delta && c1.size() < c2.size() + delta;
    }

    public Chromosome getChromosome(int index) {
        return chromosome.get(index);
    }

    public void setChromosome(int index, Chromosome chromosome) {
        try {
            this.chromosome.set(index, Chromosome.copy(chromosome));
        } catch (IndexOutOfBoundsException e) {
            this.chromosome.add(index, Chromosome.copy(chromosome));
        }
    }

    public static GenCode copy(GenCode g) {
        GenCode gCopy = new GenCode(new ArrayList<>());
        for (int i = 0; i < g.count(); i++) {
            gCopy.setChromosome(i, g.getChromosome(i));
        }
        return gCopy;
    }

}
