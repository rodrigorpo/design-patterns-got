package xyz.rpolnx.design_patterns_gof.creational_patterns.factory.method;

import lombok.ToString;

enum CoordinateSystem {
    CARTESIAN, POLAR
}

@ToString
class Point {
    private double x, y;

    //Forces the user to explicit use factory method
    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Can't creat two constructors with same types and number of arguments
//    public Point(double rho, double theta) {
//        this.x = rho * Math.cos(theta);
//        this.y = rho * Math.sin(theta);
//    }

    // Really bad
    public Point(double a, double b, CoordinateSystem coordinateSystem) {
        switch (coordinateSystem) {
            case CARTESIAN:
                this.x = a;
                this.y = b;
                break;
            case POLAR:
                this.x = a * Math.cos(b);
                this.y = a * Math.sin(b);
                break;
        }
    }

    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
    }
}

public class MethodFactory {
    public static void main(String[] args) {
        Point point1 = Point.newCartesianPoint(2, 3);
        Point point2 = Point.newPolarPoint(1, 45);

        System.out.println(point1);
        System.out.println(point2);
    }
}
