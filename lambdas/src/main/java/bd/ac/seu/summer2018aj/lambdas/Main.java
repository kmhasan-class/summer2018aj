package bd.ac.seu.summer2018aj.lambdas;


import bd.ac.seu.summer2018aj.lambdas.filter.Filter;
import bd.ac.seu.summer2018aj.lambdas.filter.FilterAgeAtLeast30;
import bd.ac.seu.summer2018aj.lambdas.filter.FilterStringTooSmall;
import bd.ac.seu.summer2018aj.lambdas.io.Reader;
import bd.ac.seu.summer2018aj.lambdas.model.Person;
import bd.ac.seu.summer2018aj.lambdas.model.Sex;

import java.util.List;

public class Main {
    // Inner class
    class FilterFemales implements Filter<Person> {

        @Override
        public boolean test(Person person) {
            return person.getSex() == Sex.FEMALE;
        }
    }

    public Main() {
        Reader reader = new Reader();
        List<Person> personList = reader.readPersonsFromCsv("persons.csv");

//        Filter<Person> filter = new FilterAgeAtLeast30();
//        Filter<Person> filter = new FilterFemales();
        Filter<Person> filter = new Filter<Person>() {
            @Override
            public boolean test(Person person) {
                // Anonymous Inner Class
                return person.getSex() == Sex.FEMALE;
            }
        };
        Filter<String> filterString = new FilterStringTooSmall();

        for (Person person : personList)
            if (filter.test(person))
                System.out.println(person);
    }

    public static void main(String args[]) {
        new Main();
    }
}
