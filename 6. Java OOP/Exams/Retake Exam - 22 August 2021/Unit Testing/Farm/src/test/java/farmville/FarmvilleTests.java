package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {

    private Farm farm;

    @Before
    public void setUp() {
        this.farm = new Farm("Farm", 1);
    }

    @Test (expected = NullPointerException.class)
    public void testIfWhenNullNameIsProvidedThrowsException() {
        new Farm(null, 15);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfWhenBelowZeroCpacityIsProvidedThrowsException() {
        new Farm("Farm", -1);
    }

    @Test (expected = NullPointerException.class)
    public void testIfWhenEmptyNameIsProvidedThrowsException() {
        new Farm(" ", 15);
    }

    @Test
    public void testIfGetCountIsCorrect() {
        farm.add(new Animal("Cow", 15.5));
        farm.add(new Animal("Dog", 17.5));
        farm.add(new Animal("Pig", 0.5));

        Assert.assertEquals(3, farm.getCount());
    }

    @Test
    public void testIfReturnsTheCorrectName() {
        Assert.assertEquals("Farm", farm.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfThrowsExceptionWhenCapacityIsReached() {
        Farm localFarm = new Farm("Fermichka", 1);
        localFarm.add(new Animal("Cow", 15.5));
        localFarm.add(new Animal("Dog", 17.5));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfAnimalAlreadyExists() {
        farm.add(new Animal("Cow", 15.5));
        farm.add(new Animal("Cow", 17.5));
    }

    @Test
    public void testShouldReturnTrueIfWeRemoveAnimal () {
        farm.add(new Animal("Cow", 15.5));
        Assert.assertTrue(this.farm.remove("Cow"));
    }

    @Test
    public void testShouldReturnFalseIfWeRemoveAnimal () {
        farm.add(new Animal("Cow", 15.5));
        Assert.assertFalse(this.farm.remove("Dog"));
    }
}
