package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AquariumTests {

    private Aquarium aquarium;
    private Fish fish;
    private List<Fish> fishList;

    @Before
    public void setUp() {
        aquarium = new Aquarium("Aquarium", 15);
        fish = new Fish("Fish");
        fishList = new ArrayList<>();
    }

    @Test
    public void testShouldReturnTheCorrectNameOfTheAquarium() {
        Assert.assertEquals("Aquarium", aquarium.getName());
    }

    @Test (expected = NullPointerException.class)
    public void testShouldThrowExceptionIfNullNameIsPassed() {
        new Aquarium(null, 15);
    }

    @Test (expected = NullPointerException.class)
    public void testShouldThrowExceptionIfEmptyNameIsPassed() {
        new Aquarium(" ", 15);
    }

    @Test
    public void testShouldReturnTheCorrectCapacity() {
        Assert.assertEquals(15, this.aquarium.getCapacity());
    }

    @Test
    public void testShouldReturnTheCorrectCountOfFish() {
        this.aquarium.add(new Fish("Fish"));
        this.aquarium.add(new Fish("Fish"));
        Assert.assertEquals(2, aquarium.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIfBelowZeroCapacityIsAdded() {
        new Aquarium("Aquarium", -1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIfTryToAddFishInFullAquarium() {
       Aquarium fullAquarium = new Aquarium("Aquarium", 1);
       fullAquarium.add(new Fish("Niki"));
       fullAquarium.add(new Fish("Yana"));
    }

    @Test
    public void testShouldBeSuccessfulIfTryToAddFishInAquarium() {
        Aquarium fullAquarium = new Aquarium("Aquarium", 1);
        fullAquarium.add(new Fish("Niki"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIfFishNameIsNotExisting() {
       aquarium.add(new Fish("Gogo"));
       aquarium.remove("Gogo");
       aquarium.remove("Niki");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSaleShouldThrowExceptionIfFishNameIsNotExisting() {
        aquarium.add(new Fish("Gogo"));
        aquarium.sellFish("Gogo");
        aquarium.sellFish("Niki");
    }

    @Test
    public void testSaleShouldReturnTrue() {
        aquarium.add(new Fish("Gogo"));
        Assert.assertFalse(aquarium.sellFish("Gogo").isAvailable());
    }

    @Test
    public void testShouldReturnTrueString() {
        aquarium.add(new Fish("Gogo"));
        aquarium.add(new Fish("Niki"));
        String expected = "Fish available at Aquarium: Gogo, Niki";
        Assert.assertEquals(expected, aquarium.report());
    }
}

