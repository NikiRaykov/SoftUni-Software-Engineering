package renovation.models;

public class Tile {
    public double width;
    public double height;
    public double depth;

    public Tile(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "models.Tile{" +
                "width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getArea() {
        return width * height;
    }
}
