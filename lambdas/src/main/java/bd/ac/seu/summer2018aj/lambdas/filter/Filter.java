package bd.ac.seu.summer2018aj.lambdas.filter;

import bd.ac.seu.summer2018aj.lambdas.model.Person;

// Functional Interfaces has exactly one method that has no implementation
@FunctionalInterface
public interface Filter<T> {
    // Review Java Generics from "The Java Tutorial"
    public boolean test(T t);

    default public void fest(T t) {
        System.out.println("I do nothing all day");
    }
}
