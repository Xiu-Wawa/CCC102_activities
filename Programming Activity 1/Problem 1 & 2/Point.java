public class Point {
    private double x;
    private double y;

    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;

        return Math.sqrt((dy * dy) + (dx * dx));
    }

    public int getQuadrant() {
        if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else if (x > 0 && y < 0) {
            return 4;
        } else {
            return 0; 
        } 
    }
}