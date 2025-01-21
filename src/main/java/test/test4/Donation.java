package test.test4;



import javax.persistence.*;

@Entity
@Table(name = "donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    private String name;
    private boolean keep_anonymous;
    private String message;

    public Donation(){}

    public Donation(int id, int amount, String name, boolean keep_anonymous, String message) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.keep_anonymous = keep_anonymous;
        this.message = message;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isKeep_anonymous() {
        return keep_anonymous;
    }

    public void setKeep_anonymous(boolean keep_anonymous) {
        this.keep_anonymous = keep_anonymous;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}



