package serg.chertkov.evolution.anima.genes;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ChromosomeTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testMutation() throws ChromosomeException {
        Chromosome c1 = new Chromosome();
        Chromosome c2;
        for (int i = 0; i < 10; i++) {
            try {
                c2 = c1.mutation(5);
            } catch (ChromosomeException e) {
                c2 = new Chromosome();
            }
            assertFalse(c1.equals(c2));
        }
        for (int i = 0; i < 10; i++) {
            try {
                c2 = c1.mutation(0);
            } catch (ChromosomeException e) {
                c2 = new Chromosome();
            }
            assertTrue(c1.equals(c2));
        }
    }

    @Test
    public void testConstructor() throws ChromosomeException {
        assertFalse(new Chromosome().equals(new Chromosome()));
    }

    @Test
    public void testConstructorCharExceptionMin() throws ChromosomeException {
        expectedEx.expect(ChromosomeException.class);
        expectedEx.expectMessage("There are not enough characters to create a chromosome.");
        new Chromosome(new char[9]);
    }

    @Test
    public void testConstructorIntExceptionMin() throws ChromosomeException {
        expectedEx.expect(ChromosomeException.class);
        expectedEx.expectMessage("There are not enough characters to create a chromosome.");
        new Chromosome(9);
    }

    @Test
    public void testConstructorCharExceptionMax() throws ChromosomeException {
        expectedEx.expect(ChromosomeException.class);
        expectedEx.expectMessage("Too few characters to create a chromosome.");
        new Chromosome(new char[101]);
    }

    @Test
    public void testConstructorIntExceptionMax() throws ChromosomeException {
        expectedEx.expect(ChromosomeException.class);
        expectedEx.expectMessage("Too few characters to create a chromosome.");
        new Chromosome(101);
    }

    @Test
    public void testSize() throws ChromosomeException {
        assertEquals(new Chromosome(new char[100]).size(), 100);
        assertEquals(new Chromosome("1234567890").size(), 10);
        assertTrue(new Chromosome(25).size() == 25);
        assertTrue(new Chromosome().size() >= 10);
        assertTrue(new Chromosome().size() <= 100);
    }

    @Test
    public void testEquals() throws ChromosomeException {
        char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        String string = "1234567890";
        assertTrue(new Chromosome(chars).equals(chars));
        assertTrue(new Chromosome(string).equals(string));
        assertTrue(new Chromosome(chars).equals(new Chromosome(string)));
    }

    @Test
    public void testPairing() throws ChromosomeException {
        char[] chars1 = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};
        char[] chars2 = {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'};
        Chromosome c1 = new Chromosome(chars1);
        Chromosome c2 = new Chromosome(chars2);
        c1.pairing(c2);
        char[] chars3 = c1.toString().toCharArray();
        int changes = 0;
        for (char aChars3 : chars3) {
            if (aChars3 == '1') {
                changes++;
            }
        }
        assertTrue(changes > 5);
    }

    @Test
    public void testPairingException() throws ChromosomeException {
        expectedEx.expect(ChromosomeException.class);
        expectedEx.expectMessage("Pairing cannot be resolved, because lengths of chromosomes are different.");
        Chromosome c1 = new Chromosome(50);
        Chromosome c2 = new Chromosome(49);
        c1.pairing(c2);
    }

    @Test
    public void testCopy() throws ChromosomeException {
        Chromosome c = new Chromosome("1234567890");
        assertTrue(Chromosome.copy(c).equals(c));
    }

    @Test
    public void testGetCleanGenes() throws ChromosomeException {
        Chromosome c1 = new Chromosome(new char[]{1, 2, 3, 4, 5, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 255, 1, 2, 3, 4, 5});
        Chromosome c2 = new Chromosome(new char[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertTrue(c2.equals(c1.getCleanGenes().get(0)));
        assertTrue(c2.getCleanGenes().size()==0);
        assertArrayEquals(new char[]{5, 6, 7, 8, 9, 0},new Chromosome(new char[]{1, 2, 3, 4, 0, 5, 6, 7, 8, 9, 0}).getCleanGenes().get(0));
    }

    @Test
    public void testGetData() throws ChromosomeException {
        double delta = 0.0001;
        Chromosome c = new Chromosome(new char[]{1, 2, 3, 4, 5, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 255, 1, 2, 3, 4, 5});
        assertEquals(0.0, c.getData(-1), delta);
        assertEquals(255.0, c.getData(16), delta);
        assertEquals(2.0, c.getData(1), delta);
        assertEquals(0.0, c.getData(-1, 16), delta);
        assertEquals(0.0, c.getData(1, -1), delta);
        assertEquals(0.0, c.getData(10, 9), delta);
        assertEquals(324.0, c.getData(1, 16), delta);
        assertEquals(339.0, c.getData(1, 100), delta);
    }
}