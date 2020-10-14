package xyz.rpolnx.design_patterns_gof.creational_patterns.prototype.serialization;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

@ToString
@AllArgsConstructor
class Foo implements Serializable {
    public String a;
    public int b;
    private boolean c;
}


public class PrototypeSerialization {
    public static void main(String[] args) {
        Foo foo1 = new Foo("a", 1, true);

        Foo foo2 = SerializationUtils.roundtrip(foo1);

        assert foo1 != foo2;

        foo2.a = "foo2";

        assert !foo1.a.equals(foo2.a);

        System.out.println(foo1);
        System.out.println(foo2);
    }
}
