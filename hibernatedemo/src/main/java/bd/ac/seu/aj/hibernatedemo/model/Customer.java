package bd.ac.seu.aj.hibernatedemo.model;

import java.time.LocalDate;
import java.util.List;

public class Customer extends Person {
    private long customerId;

    public Customer() {
        super();
    }

    public Customer(long customerId) {
        super();
        this.customerId = customerId;
    }

    public Customer(Name name, List<Address> addressList, List<Phone> phoneList, Sex sex, LocalDate dateOfBirth, long customerId) {
        super(name, addressList, phoneList, sex, dateOfBirth);
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", " + super.toString() +
                '}';
    }
}
