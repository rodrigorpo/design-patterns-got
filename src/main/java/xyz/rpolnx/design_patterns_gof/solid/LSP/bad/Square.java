package xyz.rpolnx.design_patterns_gof.solid.LSP.bad;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class Square extends Rectangle {

    public Square(BigDecimal size) {
        super(size, size);
    }

    @Override
    public void setHeight(BigDecimal height) {
        super.setHeight(height);
        //noinspection SuspiciousNameCombination
        super.setWidth(height);
    }

    @Override
    public void setWidth(BigDecimal width) {
        //noinspection SuspiciousNameCombination
        super.setHeight(width);
        super.setWidth(width);
    }
}
