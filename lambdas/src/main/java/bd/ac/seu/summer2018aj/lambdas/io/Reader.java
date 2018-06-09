package bd.ac.seu.summer2018aj.lambdas.io;

import bd.ac.seu.summer2018aj.lambdas.model.Person;
import bd.ac.seu.summer2018aj.lambdas.model.Sex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public List<Person> readPersonsFromCsv(String filename) {
        List<Person> personList = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(filename)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            bufferedReader.readLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\,");

                String name = tokens[0];
                Sex sex = Sex.valueOf(tokens[1].toUpperCase());
                int age = Integer.parseInt(tokens[2]);

                Person person = new Person(name, sex, age);

                personList.add(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personList;
    }
}
