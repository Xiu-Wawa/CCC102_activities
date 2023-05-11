public class Triangle implements BaseHeightShape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getBase() {
        return base;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public double getPerimeter() {
        double side1 = base;
        double side2 = height;
        double side3 = Math.sqrt(side1 * side1 + side2 * side2);
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle";
    }

}
