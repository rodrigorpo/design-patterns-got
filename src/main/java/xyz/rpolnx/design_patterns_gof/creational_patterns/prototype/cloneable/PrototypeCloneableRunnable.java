package xyz.rpolnx.design_patterns_gof.creational_patterns.prototype.cloneable;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
class Address implements Cloneable {
    private String street;
    private int number;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Address(street, number);
    }
}

@AllArgsConstructor
@Getter
@Setter
@ToString
class Client {
    private String name;
    private Address address;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Client(name, (Address) address.clone());
    }
}

public class PrototypeCloneableRunnable {
    @SneakyThrows
    public static void main(String[] args) {
        Address foo = new Address("Foo", 25);
        Client paul = new Client("Paul", foo);

        Client jhon = (Client) paul.clone();
        jhon.setName("jhon");

        assert paul.getAddress() != jhon.getAddress();

        jhon.getAddress().setStreet("Bar"); //we desire to modify only jhon's adress not paul

        //Cloneable points to same object references unless you implement method itself on children
        assert paul.getAddress() == jhon.getAddress();

    }
}
