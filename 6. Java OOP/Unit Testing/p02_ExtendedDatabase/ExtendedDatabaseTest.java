package unit.testing.exercise.p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExtendedDatabaseTest {

    private Database peopleDatabase;
    private static final Person[] PEOPLE = new Person[] {
            new Person(1, "George"),
            new Person(2, "David"),
            new Person(3, "Niki"),
            new Person(4, "Drago"),
            new Person(5, "John")
    };

    @Before
    public void setup() throws OperationNotSupportedException {
        this.peopleDatabase = new Database(PEOPLE);
    }

    @Test
    public void testIfConstructorCreatesValidStructure() throws OperationNotSupportedException {
        this.peopleDatabase = new Database(PEOPLE);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfTooManyElementsAreAddedToDatabase() throws OperationNotSupportedException {
        Person[] largeArr = new Person[17];

        peopleDatabase = new Database(largeArr);

        assertEquals(largeArr.length, peopleDatabase.getElements().length);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfLessThanOnePersonIsAddedToTheDatabase() throws OperationNotSupportedException {
        Person[] invalid = new Person[0];

        peopleDatabase = new Database(invalid);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testToCheckIfExceptionIsThrownWhenNullArgumentIsAdded() throws OperationNotSupportedException {
        this.peopleDatabase.add(null);
    }

    @Test
    public void testIfAddWasSuccessful() throws OperationNotSupportedException {
        Person testPerson = new Person(25, "Peter");
        this.peopleDatabase.add(testPerson);

        assertEquals(PEOPLE.length + 1, peopleDatabase.getElements().length);
    }

    @Test
    public void testIfRemoveWasSuccessful() throws OperationNotSupportedException {
        this.peopleDatabase.remove();

        assertEquals(PEOPLE.length - 1, peopleDatabase.getElements().length);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfRemoveThrowsAIOFBE() throws OperationNotSupportedException {
        Person[] people = peopleDatabase.getElements();

        for (int i = 0; i <= people.length; i++) {
            peopleDatabase.remove();
        }
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfThrowsExceptionWhenUsernameIsNull() throws OperationNotSupportedException {
        peopleDatabase.findByUsername(null);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfThrowsExceptionWhenThereIsNoSuchUsername() throws OperationNotSupportedException {
        peopleDatabase.findByUsername("Y");
    }

    @Test
    public void testIfFindByUsernameReturnsCorrectObject() throws OperationNotSupportedException {
        peopleDatabase.findByUsername("George");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfThrowsExceptionWhenThereIsNoSuchID() throws OperationNotSupportedException {
        peopleDatabase.findById(12);
    }

    @Test
    public void testIfFindByIDReturnsCorrectObject() throws OperationNotSupportedException {
        peopleDatabase.findById(1);
    }
}
