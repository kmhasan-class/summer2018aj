package bd.ac.seu.aj.summer2018.midterm;

import bd.ac.seu.aj.summer2018.midterm.model.Address;
import bd.ac.seu.aj.summer2018.midterm.model.Author;
import bd.ac.seu.aj.summer2018.midterm.model.Book;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public Main() {
        System.out.println("Hello");

        Address a1 = new Address("24 Kemal Ataturk Avenue", "Dhaka", "Bangladesh", "1213");
        System.out.println(a1);

        Author cormen = new Author(1, "Cormen", new ArrayList<>(), null);
        Author leiserson = new Author(2, "Leiserson", new ArrayList<>(), null);
        Author rivest = new Author(3, "Rivest", new ArrayList<>(), null);
        Author stein = new Author(4, "Stein", new ArrayList<>(), null);
        Author knuth = new Author(5, "Knuth", new ArrayList<>(), null);
        Author graham = new Author(6, "Graham", new ArrayList<>(), null);

        Book b1 = new Book(1234,
                "Introduction to Algorithm",
                null,
                Arrays.asList(cormen, leiserson, rivest, stein),
                LocalDate.now(),
                3);

        Book b2 = new Book(1235,
                "Algorithms Unlocked",
                null,
                Arrays.asList(cormen),
                LocalDate.now(),
                1);

        Book b3 = new Book(1236,
                "TAOCP",
                null,
                Arrays.asList(knuth),
                LocalDate.now(),
                1);

        Book b4 = new Book(1237,
                "Concrete Mathematics",
                null,
                Arrays.asList(graham, knuth),
                LocalDate.now(),
                1);

        Book b5 = new Book(1238,
                "Surreal Numbers",
                null,
                Arrays.asList(knuth),
                LocalDate.now(),
                1);

        List<Book> bookList = Arrays.asList(b1, b2, b3, b4, b5);

        bookList.stream().forEach(System.out::println);

        long max = maxAuthoredBooksByAnyAuthor(bookList);

        System.out.println(max);
    }

    long maxAuthoredBooksByAnyAuthor(List<Book> bookList) {
        long max = bookList
                .stream()
                .flatMap(book -> book.getAuthorList().stream())
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .mapToLong(aLong -> aLong)
                .max()
                .orElse(0);

        return max;
        /*
        List<Author> authorList = new ArrayList<>();
        List<Integer> frequencyList = new ArrayList<>();

        for (Book book : bookList) {
            for (Author author : book.getAuthorList()) {
                boolean found = false;

                for (int i = 0; i < authorList.size(); i++) {
                    if (authorList.get(i).equals(author)) {
                        found = true;
                        frequencyList.set(i, frequencyList.get(i) + 1);
                    }
                }

                if (!found) {
                    authorList.add(author);
                    frequencyList.add(1);
                }
            }
        }

        for (int i = 0; i < authorList.size(); i++)
            System.out.println(authorList.get(i).getName() + ": " + frequencyList.get(i));

        long max = 0;
        for (int i = 0; i < frequencyList.size(); i++)
            if (frequencyList.get(i) > max)
                max = frequencyList.get(i);

        return max;
        */
    }
    /*
    long maxAuthoredBooksByAnyAuthor(List<Book> bookList) {
        long max = bookList
                .stream()
                .flatMap(book -> book.getAuthorList().stream())
                .map(Author::getId)
                .collect(
                        Collectors.groupingBy(Function.identity(),
                                Collectors.counting()))
                .values()
                .stream()
                .mapToLong(value -> value)
                .max()
                .orElse(0);

        return max;
    }
    */

    public static void main(String args[]) {
        new Main();
    }
}
