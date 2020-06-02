package xyz.rpolnx.design_patterns_gof.solid.OCP.good;

import lombok.AllArgsConstructor;
import lombok.Getter;
import xyz.rpolnx.design_patterns_gof.solid.OCP.good.interfaces.Specification;
import xyz.rpolnx.design_patterns_gof.solid.OCP.model.Color;
import xyz.rpolnx.design_patterns_gof.solid.OCP.model.Product;

@Getter
@AllArgsConstructor
public class ColorSpecification implements Specification<Product> {
    private final Color color;

    @Override
    public boolean isSatisfied(Product item) {
        return item.getColor() == color;
    }
}
