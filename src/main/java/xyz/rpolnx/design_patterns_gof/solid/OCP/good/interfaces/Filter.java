package xyz.rpolnx.design_patterns_gof.solid.OCP.good.interfaces;

import java.util.List;
import java.util.stream.Stream;

public interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> specification);
}
