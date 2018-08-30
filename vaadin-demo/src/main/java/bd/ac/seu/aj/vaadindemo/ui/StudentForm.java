package bd.ac.seu.aj.vaadindemo.ui;

import bd.ac.seu.aj.vaadindemo.model.Student;
import com.vaadin.data.Binder;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

import java.util.Optional;

public class StudentForm extends FormLayout {
    private Binder<Student> studentBinder;

    private boolean isNumber(String string) {
        for (int i = 0; i < string.length(); i++)
            if (!Character.isDigit(string.charAt(i)))
                return false;
        return true;
    }

    public Optional<Student> getStudent() {
        Student student = new Student();
        if (studentBinder.writeBeanIfValid(student))
            return Optional.of(student);
        else return Optional.empty();
    }

    public void setStudent(Student student) {
        studentBinder.readBean(student);
    }

    public StudentForm() {
        super();
        this.setCaption("Student Form");
        TextField idField = new TextField("Student ID");
        TextField nameField = new TextField("Student Name");
        TextField cgpaField = new TextField("CGPA");
        this.addComponents(idField, nameField, cgpaField);

        studentBinder = new Binder<>();
        //studentBinder.bind(nameField, Student::getName, Student::setName);
        studentBinder
                .forField(nameField)
                .asRequired("Names cannot be empty")
                .withValidator(s -> s.length() >= 3, "Names should be at least 3 letters long")
                .bind(Student::getName, Student::setName);

        studentBinder
                .forField(idField)
                .asRequired()
                .withValidator(s -> s.length() == 4, "Student ID should be 4 digit long")
                .withValidator(s -> isNumber(s), "Student ID must be a number")
                .bind(student -> student.getId() + "",
                        (student, s) -> student.setId(Long.parseLong(s)));

        studentBinder
                .forField(cgpaField)
                .asRequired()
                .bind(student -> student.getCgpa() + "",
                        (student, s) -> student.setCgpa(Double.parseDouble(s)));

        // add a binder for the CGPA
        // has to be a number in the range [0.00, 4.00]        
    }
}
