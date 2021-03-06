package xyz.rpolnx.design_patterns_gof.solid.OCP.good;

import lombok.AllArgsConstructor;
import lombok.Getter;
import xyz.rpolnx.design_patterns_gof.solid.OCP.good.interfaces.Specification;
import xyz.rpolnx.design_patterns_gof.solid.OCP.model.Product;
import xyz.rpolnx.design_patterns_gof.solid.OCP.model.Size;

@Getter
@AllArgsConstructor
public class SizeSpecification implements Specification<Product> {
    private final Size size;

    @Override
    public boolean isSatisfied(Product item) {
        return item.getSize() == size;
    }
}
