package xyz.rpolnx.design_patterns_gof.solid.OCP.good.interfaces;

import java.util.Arrays;

public class MultipleSpecification<T> implements Specification<T> {
    private final Specification<T>[] items;

    @SafeVarargs
    public MultipleSpecification(Specification<T>... items) {
        this.items = items;
    }

    @Override
    public boolean isSatisfied(T item) {
        return Arrays.stream(items)
                .allMatch(condition -> condition.isSatisfied(item));
    }
}
