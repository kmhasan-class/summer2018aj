package bd.ac.seu.aj.midtermexample.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sport {
    @Id
    private String name;

    public Sport() {
    }

    public Sport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "name='" + name + '\'' +
                '}';
    }
}
