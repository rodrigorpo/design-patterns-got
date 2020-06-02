package xyz.rpolnx.design_patterns_gof.solid.OCP.bad;

import xyz.rpolnx.design_patterns_gof.solid.OCP.model.Color;
import xyz.rpolnx.design_patterns_gof.solid.OCP.model.Product;
import xyz.rpolnx.design_patterns_gof.solid.OCP.model.Size;

import java.util.List;
import java.util.stream.Stream;

public class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(p -> p.getColor() == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream().filter(p -> p.getSize() == size);
    }

    public Stream<Product> filterBySizeAndColor(List<Product> products, Size size, Color color) {
        return products.stream().filter(p -> p.getSize() == size  && p.getColor() == color);
    }
}
