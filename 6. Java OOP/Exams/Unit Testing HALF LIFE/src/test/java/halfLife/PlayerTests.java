package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTests {

    private Player player;
    private List<Gun> guns;

    @Before
    public void setUp() {
        this.player = new Player("test_player", 5);
        this.guns = new ArrayList<>();
    }

    @Test(expected = NullPointerException.class)
    public void testShouldFailIfNullNameIsProvided() {
        player = new Player(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldFailIfEmptyNameIsProvided() {
        player = new Player(" ", 5);
    }

    @Test
    public void testShouldReturnCorrectName() {
        Assert.assertEquals("test_player", player.getUsername());
    }

    @Test
    public void testShouldReturnCorrectHealth() {
        Assert.assertEquals(5, player.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailIfIncorrectHealthIsProvided() {
        new Player("gg", -100);
    }

    @Test
    public void testTakeDamage() {
        Player player1 = new Player("Niki", 100);
        player1.takeDamage(20);
        Assert.assertEquals(80, player1.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testAddGunShouldFailIfAddedGunIsNull() {
        player.addGun(null);
    }

    @Test
    public void testAddGun() {
        Gun ak47 = new Gun("AK47", 30);
        player.addGun(ak47);
        Assert.assertEquals(ak47, player.getGun("AK47"));
    }

    @Test
    public void testRemoveGun() {
        Gun rifle = new Gun("rifle", 25);
        player.addGun(rifle);
        boolean removedGun = player.removeGun(rifle);
        Assert.assertTrue(removedGun);
    }

    @Test
    public void testGetGun() {
        Gun pistol = new Gun("deagle", 7);
        player.addGun(pistol);
        player.getGun(pistol.getName());
        Assert.assertEquals("deagle", pistol.getName());
    }
}
