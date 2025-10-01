package Lab_05;
class Point {
    private double xCord;
    private double yCord;

    public Point(double xCord, double yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    // Getters
    public double getXCord() { return xCord; }
    public double getYCord() { return yCord; }

    // Setters
    public void setXCord(double xCord) { this.xCord = xCord; }
    public void setYCord(double yCord) { this.yCord = yCord; }

    public void display() {
        System.out.println("(" + xCord + ", " + yCord + ")");
    }
}

class Line {
    private Point startPoint;
    private Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    // Getters
    public Point getStartPoint() { return startPoint; }
    public Point getEndPoint() { return endPoint; }

    // Setters
    public void setStartPoint(Point startPoint) { this.startPoint = startPoint; }
    public void setEndPoint(Point endPoint) { this.endPoint = endPoint; }

    public double length() {
        double dx = endPoint.getXCord() - startPoint.getXCord();
        double dy = endPoint.getYCord() - startPoint.getYCord();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void display() {
        System.out.print("Line from ");
        startPoint.display();
        System.out.print(" to ");
        endPoint.display();
        System.out.println("Length = " + length());
    }
}

public class task2 {
    public static void main(String[] args) {
        Line line1 = new Line(new Point(0, 0), new Point(3, 4)); 
        Line line2 = new Line(new Point(1, 2), new Point(6, 5)); 

        line1.display();
        line2.display();
    }
}
