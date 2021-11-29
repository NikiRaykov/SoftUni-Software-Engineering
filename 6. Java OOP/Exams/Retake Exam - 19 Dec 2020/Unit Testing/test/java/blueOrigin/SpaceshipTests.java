package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {

    private Spaceship spaceship;

    @Before
    public void setUp() {
        this.spaceship = new Spaceship("Spaceship", 5);
    }

    @Test (expected = NullPointerException.class)
    public void testShouldThrowExceptionWhenNullPassed() {
        new Spaceship(null, 10);
    }

    @Test (expected = NullPointerException.class)
    public void testShouldThrowExceptionWhenBlankPassed() {
        new Spaceship(" ", 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenCapacityIsBelowZero () {
        new Spaceship("Niki", -1);
    }

    @Test
    public void testCountOfAstronauts() {
        spaceship.add(new Astronaut("Niki", 30.5));
        spaceship.add(new Astronaut("George", 22.5));
        spaceship.add(new Astronaut("Peter", 18.2));
        spaceship.add(new Astronaut("John", 7.5));

        Assert.assertEquals(4, spaceship.getCount());
    }

    @Test
    public void testShouldReturnTheCorrectName () {
        Assert.assertEquals("Spaceship", spaceship.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenSameAstronautIsAddedTwice () {
        spaceship.add(new Astronaut("Niki", 30.5));
        spaceship.add(new Astronaut("Niki", 30.5));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenCapacityIsReached () {
        Spaceship localSpaceship = new Spaceship("Spaceship", 1);
        localSpaceship.add(new Astronaut("Niki", 30.5));
        localSpaceship.add(new Astronaut("Pesho", 18.5));
    }

    @Test
    public void testShouldReturnFalseIfNoSuchAstronautExist () {
        this.spaceship.add(new Astronaut("test_1", 15.5));
        Assert.assertFalse(this.spaceship.remove("Niki"));
    }

    @Test
    public void testShouldReturnTrueIfSuchAstronautExist () {
        this.spaceship.add(new Astronaut("test_1", 15.5));
        Assert.assertTrue(this.spaceship.remove("test_1"));
    }
}
