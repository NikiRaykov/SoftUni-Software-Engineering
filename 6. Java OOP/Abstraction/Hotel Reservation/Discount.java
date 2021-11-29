public enum Discount {
    VIP(20),
    SECOND_VISIT(10),
    NONE(0);

    private final double percent;

    Discount(double value) {
        this.percent = value;
    }

    public double getPercent() {
        return percent;
    }
}
