package bd.ac.seu.aj.midtermexample.model;

import javax.validation.constraints.Min;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
public class Campus {
    @Id
    @Size(min = 3, max = 30)
    private String name;
    @Embedded
    private Address address;
    @Min(0)
    private double distance;
    @OneToOne
    private Club club;

    public Campus() {
    }

    public Campus(String name, Address address, double distance, Club club) {
        this.name = name;
        this.address = address;
        this.distance = distance;
        this.club = club;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", distance=" + distance +
                ", club=" + club +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
