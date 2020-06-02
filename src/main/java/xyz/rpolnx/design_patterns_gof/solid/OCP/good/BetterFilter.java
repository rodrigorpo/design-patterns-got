package xyz.rpolnx.design_patterns_gof.solid.OCP.good;

import xyz.rpolnx.design_patterns_gof.solid.OCP.good.interfaces.Filter;
import xyz.rpolnx.design_patterns_gof.solid.OCP.good.interfaces.Specification;
import xyz.rpolnx.design_patterns_gof.solid.OCP.model.Product;

import java.util.List;
import java.util.stream.Stream;

public class BetterFilter implements Filter<Product> {
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> specification) {
        return items.stream().filter(specification::isSatisfied);
    }
}
