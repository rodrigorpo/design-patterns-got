package xyz.rpolnx.design_patterns_gof.solid.OCP.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter @ToString
public class Product {
    private String name;
    private Color color;
    private Size size;
}
