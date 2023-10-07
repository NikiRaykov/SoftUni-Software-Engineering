package renovation.models;

public class Laminate {
    public double length;

    public double width;

    public WoodType woodType;

    public Laminate(double length, double width, WoodType woodType) {
        this.length = length;
        this.width = width;
        this.woodType = woodType;
    }

    @Override
    public String toString() {
        return "models.Laminate{" +
                "length=" + length +
                ", width=" + width +
                ", woodType='" + woodType + '\'' +
                '}';
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public WoodType getWoodType() {
        return woodType;
    }

    public void setWoodType(WoodType woodType) {
        this.woodType = woodType;
    }
}
