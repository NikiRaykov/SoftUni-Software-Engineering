package shopAndGoods;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ShopTest {

    private Shop shop;

    @Before
    public void setUp() {
        this.shop = new Shop();
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetShelves() {
        shop.getShelves().clear();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIfShelfDoesNotExist() throws OperationNotSupportedException {
        Goods testGood = new Goods("beans", "001");
        shop.addGoods("invalid_shelf", testGood);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIfShelfIsNotNull() throws OperationNotSupportedException {
        Goods testGood = new Goods("beans", "001");
        shop.addGoods("taken_shelf", testGood);
        shop.addGoods("taken_shelf", testGood);
    }

    @Test
    public void testShouldBeAbleToPutShelvesAndGoods() throws OperationNotSupportedException {
        Goods testGood = new Goods("test_good", "test_good");
        String expected = "Goods: test_good is placed successfully!";
        String actual = shop.addGoods("Shelves1", testGood);
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveThrowExceptionIfShelfDoesNotExist() throws OperationNotSupportedException {
        Goods testGood = new Goods("test_good", "test_code");
        Goods testGood_other = new Goods("test_good_other", "test_code_other");
        shop.addGoods("invalid_shelf", testGood);
        shop.removeGoods("invalid_shelf", testGood_other);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveThrowException() throws OperationNotSupportedException {
        Goods testGood = new Goods("beans", "001");
        shop.removeGoods("taken_shelf", testGood);
        shop.removeGoods("taken_shelf", testGood);
    }

    @Test
    public void testShouldBeAbleToRemoveGoods() throws OperationNotSupportedException {
        Goods testGood = new Goods("test_good", "test_good");
        shop.addGoods("Shelves1", testGood);
        String actual = shop.removeGoods("Shelves1", testGood);
        String expected = "Goods: test_good is removed successfully!";
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldSetShelfValueToNull() throws OperationNotSupportedException {
        Goods testGood = new Goods("test_good", "test_good");
        shop.addGoods("Shelves1", testGood);
        shop.removeGoods("Shelves1", testGood);

        Goods emptySlot = shop.getShelves().get("Shelves1");

        assertNull(emptySlot);
    }
}