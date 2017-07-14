package serg.chertkov.evolution.anima.genes;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GenesTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testConstructor() {
        GenCode g = new GenCode();
        assertEquals(g.count(), 10);
        assertTrue(g.size() > 10 * 10);
        int count = (int) (Math.random() * 25);
        g = new GenCode(count);
        assertEquals(g.count(), count);
    }

    @Test
    public void testSizeAndCount() throws ChromosomeException {
        List<Chromosome> c;
        int rand, size, count;
        for (int i = 0; i < 10; i++) {
            c = new ArrayList<>();
            size = 0;
            count = (int) (Math.random() * 25);
            for (int j = 0; j < count; j++) {
                rand = (int) (Math.random() * 25 + 10);
                size += rand;
                c.add(new Chromosome(new char[rand]));
            }
            GenCode g = new GenCode(c);
            assertEquals(g.count(), count);
            assertEquals(g.size(), size);
        }
    }

    @Test
    public void testPairing() throws ChromosomeException, GenCodeException {
        List<Chromosome> c1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int rand = (int) (Math.random() * 5 + 10);
            c1.add(new Chromosome(new char[rand]));
        }
        List<Chromosome> c2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int rand = (int) (Math.random() * 5 + 10);
            c2.add(new Chromosome(new char[rand]));
        }
        GenCode g1 = new GenCode(c1);
        GenCode gOld1 = GenCode.copy(g1);
        GenCode g2 = new GenCode(c2);
        GenCode gOld2 = GenCode.copy(g2);
        g1.pairing(g2);
        assertFalse(g1.equals(gOld1));
        assertFalse(g2.equals(gOld2));
    }

    @Test
    public void testPairingException() throws ChromosomeException, GenCodeException {
        expectedEx.expect(GenCodeException.class);
        expectedEx.expectMessage("Count of chromosomes are different.");
        List<Chromosome> c1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int rand = (int) (Math.random() * 5 + 10);
            c1.add(new Chromosome(new char[rand]));
        }
        List<Chromosome> c2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int rand = (int) (Math.random() * 5 + 10);
            c2.add(new Chromosome(new char[rand]));
        }
        GenCode g1 = new GenCode(c1);
        GenCode g2 = new GenCode(c2);
        g1.pairing(g2);
    }
}