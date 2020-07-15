package xyz.rpolnx.design_patterns_gof.solid.LSP;

import xyz.rpolnx.design_patterns_gof.solid.LSP.bad.Rectangle;
import xyz.rpolnx.design_patterns_gof.solid.LSP.bad.Square;
import xyz.rpolnx.design_patterns_gof.solid.LSP.good.GoodRectangle;

import java.math.BigDecimal;

public class Runner {

    public static void main(String[] args) {
        badExample();
        goodExample();
    }

    private static void goodExample() {
        // For this example we don't need a new class, actully
        GoodRectangle square = new GoodRectangle(BigDecimal.valueOf(7));
        System.out.println(square);
        square.setWidth(BigDecimal.valueOf(3));
        System.out.println(square);

        GoodRectangle rectangle = new GoodRectangle(BigDecimal.valueOf(6), BigDecimal.valueOf(4));
        System.out.println(rectangle);
        rectangle.setWidth(BigDecimal.valueOf(6));
        System.out.println(rectangle);
    }

    private static void badExample() {
        Rectangle rectangle = new Rectangle(BigDecimal.valueOf(10), BigDecimal.valueOf(5));

        System.out.println("We expect area of 50, and we got: " + rectangle.getArea());

        Rectangle square = new Square(BigDecimal.valueOf(10));
        square.setHeight(BigDecimal.valueOf(5));
        System.out.println("We expect area of 50 because its a rectangle, and we got: " + square.getArea());

        System.out.println("In this example we do not use LSP because the child cannot be substitute for father's class. " +
                "It override father's behavior for example: we cannot modify the side of a rectangle, where should be possible " +
                "since a square it is also a rectangle");
    }
}
