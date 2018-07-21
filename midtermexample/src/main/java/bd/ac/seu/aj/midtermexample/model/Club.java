package bd.ac.seu.aj.midtermexample.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Club {
    @Id
    private String name;
    @Embedded
    private Address building;
    private String phoneNumber;
    @OneToMany
    private List<Sport> sportList;

    public Club() {
    }

    public Club(String name, Address building, String phoneNumber, List<Sport> sportList) {
        this.name = name;
        this.building = building;
        this.phoneNumber = phoneNumber;
        this.sportList = sportList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getBuilding() {
        return building;
    }

    public void setBuilding(Address building) {
        this.building = building;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Sport> getSportList() {
        return sportList;
    }

    public void setSportList(List<Sport> sportList) {
        this.sportList = sportList;
    }

    @Override
    public String toString() {
        return "Club{" +
                "name='" + name + '\'' +
                ", building=" + building +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sportList=" + sportList +
                '}';
    }
}
