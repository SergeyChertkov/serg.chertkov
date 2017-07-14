package serg.chertkov.evolution.anima.genes;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Chromosome {
    private final static int MAX_SYMBOLS = 100;
    private final static int MIN_SYMBOLS = 10;
    private char[] line;

    @SuppressWarnings("WeakerAccess")
    public Chromosome() {
        line = generateCode((int) (MIN_SYMBOLS + Math.random() * (MAX_SYMBOLS - MIN_SYMBOLS)));
    }

    @SuppressWarnings("WeakerAccess")
    public Chromosome(String genes) {
        this(genes.toCharArray());
    }

    @SuppressWarnings("WeakerAccess")
    public Chromosome(char[] genes) {
        if (genes.length > MAX_SYMBOLS) {
            throw new ChromosomeException("Too few characters to create a chromosome.");
        }
        if (genes.length < MIN_SYMBOLS) {
            throw new ChromosomeException("There are not enough characters to create a chromosome.");
        }
        line = genes;
    }

    @SuppressWarnings("WeakerAccess")
    public Chromosome(int size) {
        this(generateCode(size));
    }

    @SuppressWarnings("WeakerAccess")
    public int size() {
        return line.length;
    }

    @SuppressWarnings("WeakerAccess")
    public Chromosome mutation(int maxSize) {
        if (maxSize <= 0)
            return new Chromosome(line);
        char[] newLine;
        switch ((int) (Math.random() * 3)) {
            case 0:
                newLine = removeCode(mutationFrom(), mutationSize());
                break;
            case 1:
                newLine = replaceCode(generateCode(mutationSize()), mutationFrom());
                break;
            case 2:
                newLine = addCode(generateCode(mutationSize()), mutationFrom());
                break;
            default:
                newLine = new char[0];
        }
        return new Chromosome(newLine);
    }

    private int mutationFrom() {
        return (int) (Math.random() * line.length);
    }

    private int mutationSize() {
        return (int) (Math.random() * 5 + 1);
    }

    private char[] removeCode(int from, int size) {
        char[] newLine;
        if (from + size > line.length)
            size = line.length - from;
        newLine = new char[line.length - size];
        for (int i = 0; i < newLine.length; i++) {
            newLine[i] = i < from ? line[i] : line[i + size];
        }
        return newLine;
    }

    private char[] replaceCode(char[] replaceLine, int from) {
        int size = replaceLine.length;
        if (from + size > line.length)
            size = line.length - from;
        char[] newLine = new char[line.length];
        System.arraycopy(line, 0, newLine, 0, line.length);
        System.arraycopy(replaceLine, 0, newLine, from, size);
        return newLine;
    }

    private char[] addCode(char[] addLine, int from) {
        char[] newLine = new char[line.length + addLine.length];
        for (int i = 0; i < newLine.length; i++) {
            newLine[i] = i < from ? line[i] : (i < (from + addLine.length) ? addLine[i - from] : line[i - addLine.length]);
        }
        return newLine;
    }

    private static char[] generateCode(int size) {
        char[] line = new char[size];
        for (int i = 0; i < size; i++) {
            line[i] = (char) (Math.random() * 255);
        }
        return line;
    }

    public String toString() {
        return String.copyValueOf(line);
    }

    @SuppressWarnings("WeakerAccess")
    public boolean equals(Chromosome chromosome) {
        return this.toString().equals(chromosome.toString());
    }

    @SuppressWarnings("WeakerAccess")
    public boolean equals(String chromosome) {
        return this.toString().equals(chromosome);
    }

    @SuppressWarnings("WeakerAccess")
    public boolean equals(char[] chromosome) {
        return this.toString().equals(String.copyValueOf(chromosome));
    }

    @SuppressWarnings("WeakerAccess")
    public void pairing(Chromosome chromosome) {
        if (chromosome.size() == size()) {
            char[] pairingLine = chromosome.toString().toCharArray();
            for (int i = 0; i < size(); i++) {
                if (Math.random() > 0.5) {
                    line[i] = pairingLine[i];
                }
            }
        } else {
            throw new ChromosomeException("Pairing cannot be resolved, because lengths of chromosomes are different.");
        }
    }

    @SuppressWarnings("WeakerAccess")
    public static Chromosome copy(Chromosome chromosome) {
        return new Chromosome(chromosome.toString());
    }

    @SuppressWarnings("WeakerAccess")
    public List<char[]> getCleanGenes() {
        List<char[]> result = new ArrayList<>();
        String genes = this.toString();
        String cleanGenes;
        int start;
        while (genes.indexOf((char) 0) >= 0) {
            start = genes.indexOf((char) 0);
            genes = genes.substring(start + 1);
            int end = genes.indexOf((char) 255);
            if (end > 0) {
                cleanGenes = genes.substring(0, end);
            } else {
                cleanGenes = String.format(genes);
            }
            if (!cleanGenes.isEmpty()) {
                result.add(cleanGenes.toCharArray());
            }
        }
        return result;
    }

    public char[] getCleanGenes(int index) {
        return getCleanGenes().get(index);
    }

    @SuppressWarnings("WeakerAccess")
    public double getData(int from, int to) {
        if (from < 0 || to < 0 || from > size() || from > to) {
            return 0;
        }
        int tto = to;
        if (tto > size())
            tto = size() - 1;
        double result = 0;
        for (int i = from; i <= tto; i++)
            result += ((double) line[i]);
        return result;
    }

    @SuppressWarnings("WeakerAccess")
    public double getData(int index) {
        return getData(index, index);
    }

}
