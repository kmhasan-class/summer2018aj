package bd.ac.seu.aj.summer2018.midterm.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"isbn", "title", "publicationDate", "publisher", "authorList"})
@EqualsAndHashCode(of = {"isbn"})
public class Book {
    private long isbn;
    private String title;
    private Publisher publisher;
    private List<Author> authorList;
    private LocalDate publicationDate;
    private int edition;
}
