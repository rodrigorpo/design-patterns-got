package xyz.rpolnx.design_patterns_gof.solid.OCP.good.interfaces;

public interface Specification<T> {
    boolean isSatisfied(T item);
}
