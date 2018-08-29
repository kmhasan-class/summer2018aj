package bd.ac.seu.aj.springbootdemo.model;

import bd.ac.seu.aj.springbootdemo.exception.InvalidRangeException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
//@NoArgsConstructor
@ToString
@Entity
public class Student {
    @Id
    @Min(1000)
    @Max(9999)
    private long id;
    @NotNull
    @Size(min = 3, max = 100)
    private String name;
    private double cgpa;

    public Student(@Min(1000) @Max(9999) long id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
}
