public class PriceCalculator {
    private final Double pricePerDay;
    private final int numberOfDays;
    private final Season season;
    private final Discount discountType;

    public PriceCalculator(Double pricePerDay, int numberOfDays, Season season, Discount discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double calculate() {
       return (pricePerDay * season.getMultiplier())
               * numberOfDays * (1 - (discountType.getPercent()/100.0));
    }
}
