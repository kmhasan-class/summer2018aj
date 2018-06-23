package bd.ac.seu.summer2018aj.lambdas;


import bd.ac.seu.summer2018aj.lambdas.filter.Filter;
import bd.ac.seu.summer2018aj.lambdas.filter.FilterAgeAtLeast30;
import bd.ac.seu.summer2018aj.lambdas.filter.FilterStringTooSmall;
import bd.ac.seu.summer2018aj.lambdas.io.Reader;
import bd.ac.seu.summer2018aj.lambdas.model.Person;
import bd.ac.seu.summer2018aj.lambdas.model.Sex;

import java.util.List;
import java.util.stream.Collectors;

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

/*
        // Anonymous Inner Class
        Filter<Person> filter = new Filter<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getSex() == Sex.FEMALE;
            }
        };
*/

        Filter<Person> filter = person -> person.getSex() == Sex.FEMALE;

        Filter<String> filterString = new FilterStringTooSmall();

/*
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            if (filter.test(person))
                System.out.println(person);
        }

        for (Person person : personList)
            if (filter.test(person))
                System.out.println(person);
*/

        // H.W.: study Lambda Expressions and Streams
        long countOfYoungFemales = personList
                .stream()
                .parallel()
                .filter(person -> person.getSex() == Sex.FEMALE)
                .filter(person -> person.getAge() < 30)
                .count();
        System.out.println(countOfYoungFemales);

        String youngFemaleName = personList
                .stream()
                .parallel()
                .filter(person -> person.getSex() == Sex.FEMALE)
                .filter(person -> person.getAge() < 30)
                .findFirst()
                .orElse(new Person("NOBODY", Sex.FEMALE, 99))
                .getName();
        System.out.println(youngFemaleName);

        List<Integer> ageList = personList
                .stream()
                .filter(person -> person.getAge() < 30)
                .map(person -> person.getAge())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(ageList);

        // Lab Task
        // Find out the count of person for each age value
        // Example output:
        // Age 25: 0
        // Age 26: 23
        // ...

/*

        Thread thread = new Thread(
                () -> {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(i + " Hello");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
        thread.start();
*/
    }

    public static void main(String args[]) {
        new Main();
    }
}
