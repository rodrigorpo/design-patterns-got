package xyz.rpolnx.design_patterns_gof.creational_patterns.prototype.use;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
class Foo implements Prototype<Foo> {
    private String foo;

    @Override
    public Foo clone() {
        return new Foo(foo);
    }
}

@AllArgsConstructor
@Getter
@Setter
class Bar implements Prototype<Bar> {
    private String bar;

    @Override
    public Bar clone() {
        return new Bar(bar);
    }
}

@AllArgsConstructor
@Getter
@Setter
class Foobar implements Prototype<Foobar> {
    private Foo foo;
    private Bar bar;
    private String anything;

    @Override
    public Foobar clone() {
        return new Foobar(foo.clone(), bar.clone(), anything);
    }
}

interface Prototype<T> {
    T clone();
}

public class PrototypeRunner {
    public static void main(String[] args) {
        Foobar foobar = new Foobar(new Foo("foo"), new Bar("bar"), "anything");
        Foobar clone = foobar.clone();

        assert foobar.getAnything().equals(clone.getAnything());
        assert foobar != clone;

        clone.setAnything("clone anything");
        assert !foobar.getAnything().equals(clone.getAnything());
    }
}
