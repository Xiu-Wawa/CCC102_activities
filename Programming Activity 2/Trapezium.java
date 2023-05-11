public class Trapezium implements BaseHeightShape {
    private double base1;
    private double base2;
    private double height;
    private double side1;
    private double side2;

    public Trapezium(double base1, double base2, double height, double side1, double side2) {
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getBase() {
        return (base1 + base2) / 2;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return (getBase() * getHeight());
    }

    @Override
    public double getPerimeter() {
        return base1 + base2 + side1 + side2;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    @Override
    public String toString() {
        return "Trapezium";
    }
}
