class Circle {
    private double centerX;
    private double centerY;
    private double radius;

    public Circle() {
        this.centerX = 0.0;
        this.centerY = 0.0;
        this.radius = 1.0;
    }

    public Circle(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = (radius > 0) ? radius : 1.0;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean contains(double x, double y) {
        double distanceSquared = Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2);
        return distanceSquared <= Math.pow(radius, 2);
    }
}

public class MainExercise4 {
    public static void main(String[] args) {
        Circle c1 = new Circle(0, 0, 5.0);
        Circle c2 = new Circle(2.0, 3.0, 2.5);

        System.out.println("Circle 1 Area: " + c1.area());
        System.out.println("Circle 1 Perimeter: " + c1.perimeter());
        System.out.println("Contains (3, 4): " + c1.contains(3.0, 4.0));
        System.out.println("Contains (6, 0): " + c1.contains(6.0, 0.0));

        System.out.println();

        System.out.println("Circle 2 Area: " + c2.area());
        System.out.println("Contains (2, 3): " + c2.contains(2.0, 3.0));
    }
}