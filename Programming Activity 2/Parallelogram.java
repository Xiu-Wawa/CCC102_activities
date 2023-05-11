public class Parallelogram implements BaseHeightShape {
    private double base;
    private double height;
    private double side;

    public Parallelogram(double base, double height, double side) {
        this.base = base;
        this.height = height;
        this.side = side;
    }

    public Parallelogram(double base, double height) {
        this(base, height, base);
    }

    public double getSide() {
        return side;
    }

    @Override
    public double getBase() {
        return base;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return base * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (base + side);
    }

    @Override
    public String toString() {
        return "Parallelogram";
    }
}
