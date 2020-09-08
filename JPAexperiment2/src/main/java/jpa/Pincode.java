package jpa;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Pincode {
    private int count;
    private String pincode;

    public Pincode(int count, String pincode) {
        this.count = count;
        this.pincode = pincode;
    }
}
