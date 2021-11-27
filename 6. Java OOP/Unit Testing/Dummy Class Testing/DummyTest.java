package unit.testing.lab;

import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int DEAD_DUMMY_HEALTH = -1;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int DUMMY_HEALTH = 10;

    private Dummy deadDummy;
    private Dummy dummy;

    @Before
    public void setup() {
        this.deadDummy = new Dummy(DEAD_DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void testIfDummyLosesHealthWhenItIsAttacked () {
        // Arrange
        Dummy dummy = new Dummy(15, DUMMY_EXPERIENCE);
        // Act
        dummy.takeAttack(10);
        // Assert
        assertEquals(5, dummy.getHealth());
    }


    @Test (expected = IllegalStateException.class)
    public void testIfDeadDummyThrowsExceptionWhenItIsAttacked() {
        deadDummy.takeAttack(5);
    }

    @Test
    public void testIfDeadDummyCanGiveExperience() {
        int actual = deadDummy.giveExperience();
        assertEquals(deadDummy.giveExperience(), actual);
    }

    @Test (expected = IllegalStateException.class)
    public void testIfAliveDummyCannotGiveExperience() {
        dummy.giveExperience();
    }
}
