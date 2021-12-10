package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {

    private Farm farm;

    @Before
    public void setUp() {
        this.farm = new Farm("test_farm", 1);
    }

    @Test
    public void testShouldReturnCorrectSize() {
        this.farm.add(new Animal("Cow", 12.5));
        Assert.assertEquals(1, this.farm.getCount());
    }

    @Test
    public void testShouldReturnCorrectName() {
        Assert.assertEquals("test_farm", this.farm.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldFailIfFarmIsFull() {
        this.farm.add(new Animal("Dog", 7.5));
        this.farm.add(new Animal("Horse", 7.5));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldFailIfSameAnimalIsAdded() {
        this.farm = new Farm("test", 2);
        this.farm.add(new Animal("Dog", 7.5));
        this.farm.add(new Animal("Dog", 7.5));
    }

    @Test
    public void testShouldReturnTrueIfCorrectAnimalIsTriedToBeRemoved() {
        this.farm.add(new Animal("Cow", 2));
        Assert.assertTrue(this.farm.remove("Cow"));
    }

    @Test
    public void testShouldReturnFalseIfCorrectAnimalIsTriedToBeRemoved() {
        this.farm.add(new Animal("Cow", 2));
        Assert.assertFalse(this.farm.remove("Horse"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldFailIfNegativeCapacityIsProvided() {
        Farm farm = new Farm("farm", -1);
    }

    @Test (expected = NullPointerException.class)
    public void testShouldFailIfNullNameIsProvided() {
        Farm farm = new Farm(null, 1);
    }

    @Test (expected = NullPointerException.class)
    public void testShouldFailIfEmptyNameIsProvided() {
        Farm farm = new Farm(" ", 10);
    }
}
