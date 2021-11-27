package unit.testing.exercise.p01_Database;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import static org.junit.Assert.*;

public class DatabaseTest {

    private static final Integer[] NUMBERS = {1, 2, 3, 4};
    private Database database;

    @Before
    public void setup() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testIfConstructorCreatesValidDatabase() {
        Integer[] dataBaseElements = database.getElements();

        assertArrayEquals(dataBaseElements, NUMBERS);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfTooManyElementsAreAddedToDatabase() throws OperationNotSupportedException {
        Integer[] largeArr = new Integer[17];

        database = new Database(largeArr);

        assertEquals(largeArr.length, database.getElements().length);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfThrowsExceptionWhenLessThanOneElementIsAdded() throws OperationNotSupportedException {
        Integer[] smallArr = new Integer[0];

        database = new Database(smallArr);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfThrowsExceptionWhenNullArgumentIsAdded() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void testIfElementCanBeAddedToDatabase() throws OperationNotSupportedException {
        this.database.add(2);
        Integer[] dbElements = database.getElements();

        assertEquals(NUMBERS.length + 1, dbElements.length);
        assertEquals(Integer.valueOf(2), dbElements[dbElements.length - 1]);
    }

    @Test
    public void testIfElementIsRemovedFromDatabase() throws OperationNotSupportedException {
        database.remove();
        Integer[] dbElements = database.getElements();

        assertEquals(NUMBERS.length - 1, dbElements.length);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfRemoveMethodThrowsArrayIndexOutOfBoundsException() throws OperationNotSupportedException {
        Integer[] dbElements = database.getElements();

        for (int i = 0; i <= dbElements.length; i++) {
            database.remove();
        }
    }
}
