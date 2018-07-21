package bd.ac.seu.aj.summer2018.midterm.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "name"})
@EqualsAndHashCode(of = {"id"})
public class Author {
    private long id;
    private String name;
    private List<Book> authoredBookList;
    private Address address;
}
