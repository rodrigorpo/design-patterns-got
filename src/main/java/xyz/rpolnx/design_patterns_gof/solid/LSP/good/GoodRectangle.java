package xyz.rpolnx.design_patterns_gof.solid.LSP.good;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GoodRectangle {
    private BigDecimal height;
    private BigDecimal width;
    @Getter
    @Setter
    private boolean square;

    public GoodRectangle(BigDecimal side) {
        this.height = side;
        this.width = side;
        this.square = true;
    }

    public GoodRectangle(BigDecimal height, BigDecimal width) {
        this.height = height;
        this.width = width;
    }

    public BigDecimal getArea() {
        return height.multiply(width);
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.square = height.equals(width);
        this.height = height;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.square = height.equals(width);
        this.width = width;
    }
}
