package xyz.rpolnx.design_patterns_gof;

import xyz.rpolnx.design_patterns_gof.creational_patterns.builder.Person;

class PersonFacadeBuilder {
    protected Person person = new Person();

    public PersonFacadeBuilder withName(String name) {
        person.name = name;
        return this;
    }

    public Person build() {
        return person;
    }

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }
}

class PersonAddressBuilder extends PersonFacadeBuilder {
    public PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder at(String streetAddress) {
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder withPostcode(String postcode) {
        person.postcode = postcode;
        return this;
    }

    public PersonAddressBuilder in(String city) {
        person.city = city;
        return this;
    }
}

class PersonJobBuilder extends PersonFacadeBuilder {
    public PersonJobBuilder(Person person) {
        this.person = person;
    }

    public PersonJobBuilder at(String companyName) {
        person.companyName = companyName;
        return this;
    }

    public PersonJobBuilder asA(String position) {
        person.position = position;
        return this;
    }

    public PersonJobBuilder earning(int annualIncome) {
        person.annualIncome = annualIncome;
        return this;
    }
}

public class FacadeBuilder {
    public static void main(String[] args) {
        System.out.println("Using facade with fluent builder, you can switch between builders and construct " +
                "partial instance\n");

        PersonFacadeBuilder pb = new PersonFacadeBuilder();
        Person person = pb
                    .withName("Rodrigo")
                .lives()
                    .at("Rua Jk")
                    .in("Uberlandia")
                    .withPostcode("38402567")
                .works()
                    .at("Software Company")
                    .asA("Backend Developer")
                    .earning(500)
                .build();

        System.out.println(person);

    }
}
