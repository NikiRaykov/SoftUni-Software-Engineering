package craftsmanLab.core;

import craftsmanLab.models.ApartmentRenovation;
import craftsmanLab.models.Craftsman;

import java.util.*;

public class CraftsmanLabImpl implements CraftsmanLab {

    private List<Craftsman> craftsmen = new ArrayList<>();
    private Set<ApartmentRenovation> apartments = new HashSet<>();

    @Override
    public void addApartment(ApartmentRenovation job) {
        if (apartments.stream().anyMatch(a -> a.getAddress().equals(job.getAddress()))) {
            throw new IllegalArgumentException();
        }

        this.apartments.add(job);
        }

    @Override
    public void addCraftsman(Craftsman craftsman) {
        if (craftsmen.contains(craftsman)) {
            throw new IllegalArgumentException();
        }

        this.craftsmen.add(craftsman);
    }

    @Override
    public boolean exists(ApartmentRenovation job) {
        return this.apartments.contains(job);
    }

    @Override
    public boolean exists(Craftsman craftsman) {
        return this.craftsmen.contains(craftsman);
    }

    @Override
    public void removeCraftsman(Craftsman craftsman) {
        if (exists(craftsman)) {
            throw new IllegalArgumentException();
        }

        for (ApartmentRenovation job : apartments) {
            if (job.getAssignedCraftsman() != null && job.getAssignedCraftsman().equals(craftsman)) {
                throw new IllegalArgumentException();
            }
        }

        this.craftsmen.remove(craftsman);
    }

    @Override
    public Collection<Craftsman> getAllCraftsmen() {
        return new ArrayList<>(craftsmen);
    }

    @Override
    public void assignRenovations() {

    }

    @Override
    public Craftsman getContractor(ApartmentRenovation job) {
        if (job.getAssignedCraftsman() == null) {
            throw new IllegalArgumentException();
        }

        return job.getAssignedCraftsman();
    }

    @Override
    public Craftsman getLeastProfitable() {
        if (craftsmen.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Craftsman leastProfitableCraftsman = null;

        double lowestEarnings = Double.MAX_VALUE;

        for (Craftsman craftsman : craftsmen) {
            if (craftsman.getTotalEarnings() < lowestEarnings) {
                lowestEarnings = craftsman.getTotalEarnings();
                leastProfitableCraftsman = craftsman;
            }
        }
        return leastProfitableCraftsman;
    }

    @Override
    public Collection<ApartmentRenovation> getApartmentsByRenovationCost() {
        List<ApartmentRenovation> sortedApartments = new ArrayList<>(apartments);

       Comparator<ApartmentRenovation> byRenovationCost = (apartment1, apartment2) -> {
           double cost1 = apartment1.getRenovationCost();
           double cost2 = apartment2.getRenovationCost();

           return Double.compare(cost1, cost2);
       };

        sortedApartments.sort(byRenovationCost);

        return sortedApartments;
    }

    @Override
    public Collection<ApartmentRenovation> getMostUrgentRenovations(int limit) {
        List<ApartmentRenovation> sortedApartments = new ArrayList<>(apartments);

        Comparator<ApartmentRenovation> byDeadline = Comparator.comparing(ApartmentRenovation::getDeadline);

        sortedApartments.sort(byDeadline);

        int resultCount = Math.min(limit, sortedApartments.size());

        return sortedApartments.subList(0, resultCount);
    }

}
