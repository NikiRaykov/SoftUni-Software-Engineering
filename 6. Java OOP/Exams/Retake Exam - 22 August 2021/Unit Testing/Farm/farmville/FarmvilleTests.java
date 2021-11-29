package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {

    private Farm farm;

    @Before
    public void setUp() {
        this.farm = new Farm("Farm", 5);
    }

    @Test (expected = NullPointerException.class)
    public void testShouldThrowExceptionWhenNullPassed() {
        new Farm(null, 10);
    }

    @Test (expected = NullPointerException.class)
    public void testShouldThrowExceptionWhenBlankPassed() {
        new Farm(" ", 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenCapacityIsBelowZero () {
        new Farm("Niki", -1);
    }

    @Test
    public void testCountOfAstronauts() {
        farm.add(new Animal("Niki", 30.5));
        farm.add(new Animal("George", 22.5));
        farm.add(new Animal("Peter", 18.2));
        farm.add(new Animal("John", 7.5));

        Assert.assertEquals(4, farm.getCount());
    }

    @Test
    public void testShouldReturnTheCorrectName () {
        Assert.assertEquals("Farm", farm.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenSameAstronautIsAddedTwice () {
        farm.add(new Animal("Cow", 30.5));
        farm.add(new Animal("Cow", 30.5));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenCapacityIsReached () {
        Farm localFarm = new Farm("Spaceship", 1);
        localFarm.add(new Animal("Niki", 30.5));
        localFarm.add(new Animal("Pesho", 18.5));
    }

    @Test
    public void testShouldReturnFalseIfNoSuchAstronautExist () {
        this.farm.add(new Animal("test_1", 15.5));
        Assert.assertFalse(this.farm.remove("Niki"));
    }

    @Test
    public void testShouldReturnTrueIfSuchAstronautExist () {
        this.farm.add(new Animal("test_1", 15.5));
        Assert.assertTrue(this.farm.remove("test_1"));
    }
}
