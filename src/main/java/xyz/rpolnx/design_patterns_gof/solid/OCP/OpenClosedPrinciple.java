package xyz.rpolnx.design_patterns_gof.solid.OCP;

import xyz.rpolnx.design_patterns_gof.solid.OCP.bad.ProductFilter;
import xyz.rpolnx.design_patterns_gof.solid.OCP.good.BetterFilter;
import xyz.rpolnx.design_patterns_gof.solid.OCP.good.ColorSpecification;
import xyz.rpolnx.design_patterns_gof.solid.OCP.good.SizeSpecification;
import xyz.rpolnx.design_patterns_gof.solid.OCP.good.interfaces.MultipleSpecification;
import xyz.rpolnx.design_patterns_gof.solid.OCP.model.Color;
import xyz.rpolnx.design_patterns_gof.solid.OCP.model.Product;
import xyz.rpolnx.design_patterns_gof.solid.OCP.model.Size;

import java.util.List;

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        printBadPattern(getProducts());

        printGoodPattern(getProducts());
    }

    private static void printBadPattern(List<Product> products) {
        ProductFilter productFilter = new ProductFilter();

        System.out.println("Green products are:");
        productFilter.filterByColor(products, Color.GREEN)
                .forEach(System.out::println);

        System.out.println("\nSmall products are:");
        productFilter.filterBySize(products, Size.SMALL)
                .forEach(System.out::println);

        System.out.println("\nGreen and medium products are:");
        productFilter.filterBySizeAndColor(products, Size.MEDIUM, Color.GREEN)
                .forEach(System.out::println);
    }

    private static void printGoodPattern(List<Product> products) {
        BetterFilter betterFilter = new BetterFilter();

        System.out.println("\n\nGreen products are:");
        betterFilter.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(System.out::println);

        System.out.println("\nSmall products are:");
        betterFilter.filter(products, new SizeSpecification(Size.SMALL))
                .forEach(System.out::println);

        System.out.println("\nGreen and large products are:");
        betterFilter
                .filter(products, new MultipleSpecification<>(new SizeSpecification(Size.LARGE),
                        new ColorSpecification(Color.GREEN)))
                .forEach(System.out::println);
    }

    private static List<Product> getProducts() {
        Product car = new Product("Car", Color.BLUE, Size.LARGE);
        Product tree = new Product("Tree", Color.GREEN, Size.MEDIUM);
        Product pencil = new Product("Pencil", Color.RED, Size.SMALL);

        return List.of(car, tree, pencil);
    }

}
