package bd.ac.seu.aj.springbootdemo.model;

import bd.ac.seu.aj.springbootdemo.exception.InvalidRangeException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
//@NoArgsConstructor
@ToString
@Entity
public class Student {
    @Id
    private long id;
    private String name;
    private double cgpa;

    public Student(long id, String name, double cgpa) {
        if (id < 1000)
            throw new InvalidRangeException("Student IDs must be more than 999");
        if (id > 9999)
            throw new InvalidRangeException("Student IDs must be less than 10000");

        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public void setCgpa(double cgpa) {
        if (cgpa >= 0 && cgpa <= 4.0)
            this.cgpa = cgpa;
        else {
            System.err.println("Invalid value for CGPA. CGPA should be within the range [0.00, 4.00].");
            throw new InvalidRangeException("Invalid value for CGPA. CGPA should be within the range [0.00, 4.00].");
        }
    }
}
