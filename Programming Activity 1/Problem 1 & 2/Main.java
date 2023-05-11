/**

Author: Joshua Timothy O. Clet
BSCS 3rd Year

This is the main of the Line.java and Point.java Program

*/

public class Main {
    public static void main(String[] args) {
        // Create two Point objects
        Point p1 = new Point(3.0, 6.0);
        Point p2 = new Point(2.0, 2.0);

        System.out.println("Point1 = (" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("Point2 = (" + p2.getX() + ", " + p2.getY() + ")");
        System.out.println();

        // Calculate the distance between the points
        double distance = p1.distance(p2);
        System.out.println("Distance between points: " + distance);

        // Get the quadrant of each point
        int quad1 = p1.getQuadrant();
        int quad2 = p2.getQuadrant();
        System.out.println("Quadrant of point 1: " + quad1);
        System.out.println("Quadrant of point 2: " + quad2);

        // creates a new instance of the Line class and print the Slope
        Line line = new Line(p1, p2);
        System.out.println("Slope of the line: " + line.slope());

    }
}
