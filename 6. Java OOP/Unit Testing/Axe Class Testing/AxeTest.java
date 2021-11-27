package unit.testing.lab;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTest {

    @Test
    public void testIfAttackDecreasesAfterEachAttack() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(100, 100);

        axe.attack(dummy);

        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

    @Test (expected = IllegalStateException.class)
    public void testIfAttackIsPossibleWithBrokenAxe() throws IllegalStateException {
        Axe axe = new Axe(10, 0);
        Dummy dummy = new Dummy(100, 100);
        axe.attack(dummy);
        Assert.assertEquals(0,  axe.getDurabilityPoints());
    }
}
