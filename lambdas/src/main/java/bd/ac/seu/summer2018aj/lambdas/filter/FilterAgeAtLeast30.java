package bd.ac.seu.summer2018aj.lambdas.filter;

import bd.ac.seu.summer2018aj.lambdas.model.Person;

public class FilterAgeAtLeast30 implements Filter<Person> {
    @Override
    public boolean test(Person person) {
        if (person.getAge() >= 30)
            return true;
        else return false;
    }
}
