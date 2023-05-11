public class Rhombus implements BaseHeightShape {
    private double diagonal1;
    private double diagonal2;

    public Rhombus(double diagonal1, double diagonal2) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    @Override
    public double getBase() {
        return Math.sqrt(Math.pow(diagonal1 / 2, 2) + Math.pow(diagonal2 / 2, 2));
    }

    @Override
    public double getHeight() {
        return (2 * getArea()) / getBase();
    }

    @Override
    public double getArea() {
        return (diagonal1 * diagonal2) / 2;
    }

    @Override
    public double getPerimeter() {
        return 4 * getSide();
    }

    public double getSide() {
        return Math.sqrt(Math.pow(diagonal1 / 2, 2) + Math.pow(diagonal2 / 2, 2));
    }

    @Override
    public String toString() {
        return "Rhombus";
    }
}
