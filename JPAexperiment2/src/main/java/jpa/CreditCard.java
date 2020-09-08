package jpa;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Embeddable
public class CreditCard {
    @Id
    private int number;
    private int limit;
    private int balance;
    @Embedded
    private Bank bank;
    @Embedded
    private Pincode pincode;
    public CreditCard(int number, int limit, int balance) {
        this.number = number;
        this.limit = limit;
        this.balance = balance;
    }
}
