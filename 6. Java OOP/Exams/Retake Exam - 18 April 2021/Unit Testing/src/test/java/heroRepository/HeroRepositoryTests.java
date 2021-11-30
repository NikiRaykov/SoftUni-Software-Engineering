package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HeroRepositoryTests {

    private HeroRepository repo;
    private Hero hero;

    @Before
    public void setUp() {
        this.repo = new HeroRepository();
        this.hero = new Hero("Geralt", 17);
    }

    @Test
    public void testShouldReturnCorrectCount() {
        this.repo.create(new Hero("Geralt", 8));
        Assert.assertEquals(1, this.repo.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testShouldFailWhenNullHeroIsCreated() {
        this.repo.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailWhenHeroWithTheSameNameIsAdded() {
        this.repo.create(new Hero("Geralt", 8));
        this.repo.create(new Hero("Geralt", 8));
    }

    @Test(expected = NullPointerException.class)
    public void testShouldFailWhenTheNameOfTheHeroIsNull() {
        this.repo.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldFailWhenTheNameOfTheHeroIsEmpty() {
        this.repo.remove(" ");
    }

    @Test
    public void testShouldReturnTrueIfRemovingWasASuccess() {
        this.repo.create(new Hero("Geralt", 8));
        Assert.assertTrue(this.repo.remove("Geralt"));
    }

    @Test
    public void testShouldReturnFalseIfRemovingWasNotASuccess() {
        this.repo.create(new Hero("Gosho", 8));
        Assert.assertFalse(this.repo.remove("Geralt"));
    }

    @Test
    public void testShouldReturnTheHeroWithTheHighestLevel() {
        this.repo.create(new Hero("Geralt", 8));
        this.repo.create(new Hero("Conor", 9));
        this.repo.create(new Hero("Nate", 10));
        Assert.assertEquals(10, this.repo.getHeroWithHighestLevel().getLevel());
    }

    @Test
    public void testShouldReturnTheHeroWithTheSameName() {
        Hero hero = new Hero("Geralt", 8);
        this.repo.create(hero);
        Assert.assertEquals(this.repo.getHero("Geralt"), this.repo.getHero(hero.getName()));
    }

}
