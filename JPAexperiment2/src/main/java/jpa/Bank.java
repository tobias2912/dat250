package jpa;

import javax.persistence.Embeddable;

@Embeddable
public class Bank {
    private String name;

    public Bank(String name) {
        this.name = name;
    }
}
