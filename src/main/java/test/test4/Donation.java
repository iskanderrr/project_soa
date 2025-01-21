package test.test4;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int amount;
    @Column
    private String name;
    @Column
    private boolean keep_anonymous;
    @Column
    private String message;

    public Donation(){}

    public Donation(int id, int amount, String name, boolean keep_anonymous, String message) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.keep_anonymous = keep_anonymous;
        this.message = message;

    }

    @XmlElement
    public int getId() {
        return id;
    }
    @XmlElement
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public int getAmount() {
        return amount;
    }
    @XmlElement
    public void setAmount(int amount) {
        this.amount = amount;
    }
    @XmlElement
    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public boolean isKeep_anonymous() {
        return keep_anonymous;
    }
    @XmlElement
    public void setKeep_anonymous(boolean keep_anonymous) {
        this.keep_anonymous = keep_anonymous;
    }
    @XmlElement
    public String getMessage() {
        return message;
    }
    @XmlElement
    public void setMessage(String message) {
        this.message = message;
    }
}



