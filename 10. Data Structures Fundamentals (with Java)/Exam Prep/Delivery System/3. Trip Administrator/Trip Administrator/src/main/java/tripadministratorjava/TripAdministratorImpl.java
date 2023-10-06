package tripadministratorjava;

import java.util.*;
import java.util.stream.Collectors;

public class TripAdministratorImpl implements TripAdministrator {

    private Map<String ,Company> companies;

    private Map<String, Trip> tripsById;
    private Map<String, List<Trip>> companiesWithTrips;

    public TripAdministratorImpl() {
        this.companies = new LinkedHashMap<>();
        this.tripsById = new LinkedHashMap<>();
        this.companiesWithTrips = new LinkedHashMap<>();
    }

    @Override
    public void addCompany(Company c) {
        if (companies.containsKey(c.name)) {
            throw new IllegalArgumentException();
        }

        companiesWithTrips.put(c.name, new ArrayList<>());
        companies.put(c.name, c);
    }

    @Override
    public void addTrip(Company c, Trip t) {
        if (!companies.containsKey(c.name) || exist(t)) {
            throw new IllegalArgumentException();
        }

        companiesWithTrips.get(c.name).add(t);
        tripsById.put(t.id, t);
    }

    @Override
    public boolean exist(Company c) {
        return companies.containsKey(c.name);
    }

    @Override
    public boolean exist(Trip t) {
        return tripsById.containsKey(t.id);
    }

    @Override
    public void removeCompany(Company c) {
        if (!companies.containsKey(c.name)) {
            throw new IllegalArgumentException();
        }

        companies.remove(c.name);
        companiesWithTrips.remove(c.name);
    }

    @Override
    public Collection<Company> getCompanies() {
        return companies.values();
    }

    @Override
    public Collection<Trip> getTrips() {
        return tripsById.values();
    }

    @Override
    public void executeTrip(Company c, Trip t) {
        if (!exist(c) || !exist(t)) {
            throw new IllegalArgumentException();
        }

        List<Trip> companyTrips = companiesWithTrips.get(c.name);

        boolean removed = companyTrips.removeIf(tr -> tr.id.equals(t.id));

        if (!removed) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Collection<Company> getCompaniesWithMoreThatNTrips(int n) {
        return getCompanies()
                .stream()
                .filter(c -> c.tripOrganizationLimit > n)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Trip> getTripsWithTransportationType(Transportation t) {
        return getTrips()
                .stream()
                .filter(tr -> tr.transportation == t)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Trip> getAllTripsInPriceRange(int lo, int hi) {
        return getTrips()
                .stream()
                .filter(trip -> trip.price >= lo && trip.price <= hi)
                .collect(Collectors.toList());
    }

}
