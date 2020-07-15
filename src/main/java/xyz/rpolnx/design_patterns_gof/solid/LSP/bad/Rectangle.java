package xyz.rpolnx.design_patterns_gof.solid.LSP.bad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rectangle {
    private BigDecimal height;
    private BigDecimal width;

    public BigDecimal getArea() {
        return height.multiply(width);
    }
}
