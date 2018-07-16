package bd.ac.seu.aj.summer2018.midterm.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"name", "address"})
@EqualsAndHashCode(of = {"name"})
public class Publisher {
    public long id;
    private String name;
    private Address address;
    private List<Book> publishedBookList;
}
