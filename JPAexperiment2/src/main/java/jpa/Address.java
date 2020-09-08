package jpa;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.util.ArrayList;

@Embeddable
public class Address {
    @Id
    private String street;
    @Id
    private int number;

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }
}
