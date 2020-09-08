package jpa;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Person {
    @Id
    private String name;
    @ElementCollection
    private ArrayList<Address> adresses;
    @ElementCollection
    private ArrayList<CreditCard> cards;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Address> getAdresses() {
        return adresses;
    }

    public void setAdresses(ArrayList<Address> adresses) {
        this.adresses = adresses;
    }

    public ArrayList<CreditCard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<CreditCard> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "jpa.Person{" +
                "name='" + name + '\'' +
                ", adresses=" + adresses +
                ", cards=" + cards +
                '}';
    }
}
