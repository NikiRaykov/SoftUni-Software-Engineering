package tripadministratorjava;

import tripadministratorjava.Company;
import tripadministratorjava.Transportation;
import tripadministratorjava.Trip;
import tripadministratorjava.TripAdministratorImpl;

import org.junit.Before;
import org.junit.Test;

public class Test007 {

    private TripAdministratorImpl tripAdministrations;
    private Company c2 = new Company("b", 1);
    private Trip t1 = new Trip("a", 1, Transportation.NONE, 1);

    @Before
    public void Setup() {
        this.tripAdministrations = new TripAdministratorImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddTripForNonExistentCompany() {
        this.tripAdministrations.addTrip(c2, t1);
    }
}