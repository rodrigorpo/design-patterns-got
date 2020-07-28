package xyz.rpolnx.design_patterns_gof.creational_patterns.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    public String name;

    //address
    public String streetAddress, postcode, city;

    // employment
    public String companyName, position;
    public int annualIncome;
}

class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    public Person build() {
        return person;
    }

    protected SELF self() {
        // we always have an instance extending PersonBuilder. So it's ok
        //noinspection unchecked
        return (SELF) this;
    }
}

@ToString
class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}


class PersonRunner {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder<>();
        Person rodrigo = pb.withName("Rodrigo").build();
        System.out.println(rodrigo + "\n\n");

        System.out.println("If we inheritance, we got a problem: if we use the child as initial builder, we cannot use " +
                "father's methods. This is because the father's returns is an instance of father and not from the child." +
                "A way to solve this is casting with generics");

        EmployeeBuilder pbFluentInheritance = new EmployeeBuilder();
        Person rodrigoWithInheritance = pbFluentInheritance
                .withName("Rodrigo")
                    .worksAt("Developer")
                .build();
        System.out.println(rodrigoWithInheritance);


    }
}