package serg.chertkov.evolution.anima.organs;

import org.junit.Test;
import serg.chertkov.evolution.anima.genes.Chromosome;

import static org.junit.Assert.*;

public class NeuronTest {
    @Test
    public void testAction() {
        double[] impulses1 = {3, 2, 1};
        double[] impulses2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 2, 3, 4, 5};
        double delta = 0.0001;
        Chromosome chromosome = new Chromosome(new char[]{1, 2, 3, 0, 250, 1, 1, 130, 131, 132, 133, 134, 135, 136, 137, 255, 1, 2, 3});
        Neuron neuron = new Neuron(chromosome.getCleanGenes(0));
        assertEquals(0, neuron.action(new double[]{}), delta);
        assertEquals(16, neuron.action(impulses1), delta);
        assertEquals(200, neuron.action(impulses2), delta);
        chromosome = new Chromosome(new char[]{0, 250, 1, 1, 133, 130, 255, 1, 1, 1});
        neuron = new Neuron(chromosome.getCleanGenes(0));
        assertEquals(20, neuron.action(new double[]{2, 5}), delta);
    }
}