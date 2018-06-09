package bd.ac.seu.summer2018aj.lambdas.filter;

public class FilterStringTooSmall implements Filter<String> {
    @Override
    public boolean test(String s) {
        if (s.length() < 5)
            return true;
        return false;
    }
}
