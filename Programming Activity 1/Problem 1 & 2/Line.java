public class Line {
    private Point point1;
    private Point point2;


    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }


    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    
    public void setPoint2(Point point2) {
        this.point2 = point2;
    }


    public Point getPoint1() {
        return point1;
    }


    public Point getPoint2() {
        return point2;
    }


    public double slope() {
        double deltaX = point2.getX() - point1.getX();
        double deltaY = point2.getY() - point1.getY();

        if (deltaX == 0) {
            return Double.POSITIVE_INFINITY;
        } 
        else {
            return deltaY / deltaX;
        }
    }
}