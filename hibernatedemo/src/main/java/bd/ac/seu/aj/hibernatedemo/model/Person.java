package bd.ac.seu.aj.hibernatedemo.model;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@MappedSuperclass
public class Person {
    @Embedded
    private Name name;
    @OneToMany
    private List<Address> addressList;
    @OneToMany
    private List<Phone> phoneList;
    private Sex sex;
    private LocalDate dateOfBirth;

    public Person() {
    }

    public Person(Name name, List<Address> addressList, List<Phone> phoneList, Sex sex, LocalDate dateOfBirth) {
        this.name = name;
        this.addressList = addressList;
        this.phoneList = phoneList;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", addressList=" + addressList +
                ", phoneList=" + phoneList +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
