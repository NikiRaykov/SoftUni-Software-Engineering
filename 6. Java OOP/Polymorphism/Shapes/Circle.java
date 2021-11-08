public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public Double calculatePerimeter() {
        return Math.PI*(2 * getRadius());
    }

    @Override
    public Double calculateArea() {
        return Math.PI * Math.pow(getRadius(),2);
    }
}
