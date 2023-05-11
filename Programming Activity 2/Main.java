public class Main {
    public static void main(String[] args) {
        Shape triangle = new Triangle(3, 4);
        Shape circle = new Circle(5);
        Shape semicircle = new SemiCircle(6);
        Shape square = new Square(7);
        Shape rectangle = new Rectangle(8, 6);
        Shape parallelogram = new Parallelogram(10, 11, 6);
        Shape rhombus = new Rhombus(12, 13);
        Shape trapezium = new Trapezium(15, 5, 16, 8, 10);

        Shape[] shapes = {triangle, circle, semicircle, square, rectangle, parallelogram, rhombus, trapezium};

        for (Shape shape : shapes) {
            System.out.println(shape.toString());
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter());
            System.out.println();
        }
    }
}
