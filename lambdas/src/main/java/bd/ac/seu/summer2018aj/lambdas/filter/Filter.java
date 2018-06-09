package bd.ac.seu.summer2018aj.lambdas.filter;

import bd.ac.seu.summer2018aj.lambdas.model.Person;

public interface Filter<T> {
    public boolean test(T t);
}
