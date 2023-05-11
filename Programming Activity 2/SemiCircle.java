public class SemiCircle implements CircularShape {
    private double radius;

    public SemiCircle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius / 2;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius + 2 * radius;
    }

    @Override
    public String toString() {
        return "Semicircle";
    }
}
