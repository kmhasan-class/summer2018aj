package bd.ac.seu.aj.hibernatedemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Employee extends Person {
    @Id
    private long employeeId;
    private LocalDate joiningDate;
    private Rank rank;

    public Employee() {
        super();
    }

    public Employee(long employeeId) {
        super();
        this.employeeId = employeeId;
    }

    public Employee(Name name, List<Address> addressList, List<Phone> phoneList, Sex sex, LocalDate dateOfBirth, long employeeId) {
        super(name, addressList, phoneList, sex, dateOfBirth);
        this.employeeId = employeeId;
    }

    public Employee(Name name,
                    List<Address> addressList,
                    List<Phone> phoneList,
                    Sex sex,
                    LocalDate dateOfBirth,
                    long employeeId,
                    LocalDate joiningDate,
                    Rank rank) {
        super(name, addressList, phoneList, sex, dateOfBirth);
        this.employeeId = employeeId;
        this.joiningDate = joiningDate;
        this.rank = rank;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", joiningDate=" + joiningDate +
                ", rank=" + rank +
                ", " + super.toString() +
                '}';
    }
}
