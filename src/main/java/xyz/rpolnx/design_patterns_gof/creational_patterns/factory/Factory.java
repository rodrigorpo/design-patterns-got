package xyz.rpolnx.design_patterns_gof.creational_patterns.factory;

import lombok.ToString;

@ToString
class Point {
    private double x, y;

    //Forces the user to explicit use factory method
    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static class Factory {
        public static Point newCartesianPoint(double x, double y) {
            return new Point(x, y);
        }

        public static Point newPolarPoint(double rho, double theta) {
            return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
        }
    }
}


public class Factory {
    public static void main(String[] args) {
        Point point = Point.Factory.newCartesianPoint(3, 4);
//        Point point2 = new Point(1,2); -- construct are not public anymore
        System.out.println(point);
    }
}
