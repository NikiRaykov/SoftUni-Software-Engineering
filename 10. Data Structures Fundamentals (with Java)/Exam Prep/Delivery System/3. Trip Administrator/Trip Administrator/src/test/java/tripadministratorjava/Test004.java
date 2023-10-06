package tripadministratorjava;

import tripadministratorjava.Company;
import tripadministratorjava.Transportation;
import tripadministratorjava.Trip;
import tripadministratorjava.TripAdministratorImpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test004 {

    private TripAdministratorImpl tripAdministrations;
    private Company c1 = new Company("a", 2);
    private Trip t1 = new Trip("a", 1, Transportation.NONE, 1);

    @Before
    public void Setup() {
        this.tripAdministrations = new TripAdministratorImpl();
    }


    @Test
    public void TestAddTrip() {
        this.tripAdministrations.addCompany(c1);
        this.tripAdministrations.addTrip(c1, t1);

        assertTrue(this.tripAdministrations.exist(t1));
    }
}