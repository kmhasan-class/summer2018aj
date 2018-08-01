package bd.ac.seu.aj.vaadindemo.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
public class Student {
    private long id;
    private String name;
    private double cgpa;
}
