package bd.ac.seu.aj.vaadindemo.ui;

import bd.ac.seu.aj.vaadindemo.model.Student;
import bd.ac.seu.aj.vaadindemo.service.StudentService;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringUI
@Theme("valo")
public class HelloUI extends UI {
    private StudentService studentService;

    public HelloUI(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    private boolean isNumber(String string) {
        for (int i = 0; i < string.length(); i++)
            if (!Character.isDigit(string.charAt(i)))
                return false;
        return true;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Label label = new Label("Hello World");
        Button button = new Button("Click Me");
        Grid<Student> studentGrid = new Grid<>();
        studentGrid.setCaption("List of Students");
        studentGrid.setItems(studentService.getAllStudents());
        studentGrid.addColumn(Student::getId).setCaption("Student ID");
        studentGrid.addColumn(Student::getName).setCaption("Student Name");
        studentGrid.addColumn(Student::getCgpa).setCaption("CGPA");
        studentGrid.setSelectionMode(Grid.SelectionMode.MULTI);

        button.addClickListener(clickEvent -> {
            label.setValue("AJ");
            Notification.show("Hello");
        });

        Button waiverButton = new Button("Waive Tuition");
        waiverButton.addClickListener(clickEvent -> {
            System.out.println("Selected student");
            Set<Student> selectedSetudentSet = studentGrid.getSelectedItems();
            selectedSetudentSet.stream().forEach(System.out::println);
        });

        FormLayout studentForm = new FormLayout();
        studentForm.setCaption("Student Form");
        TextField idField = new TextField("Student ID");
        TextField nameField = new TextField("Student Name");
        TextField cgpaField = new TextField("CGPA");
        Button saveButton = new Button("Save");
        studentForm.addComponents(idField, nameField, cgpaField, saveButton);

        Binder<Student> studentBinder = new Binder<>();
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

        // add a binder for the CGPA
        // has to be a number in the range [0.00, 4.00]
        
        saveButton.addClickListener(clickEvent -> {
            Student student = new Student();
            studentBinder.writeBeanIfValid(student);
            Notification.show(student.toString());
        });
/*
        // JavaFX Example
        // on click of some button
        long id = Long.parseLong(idField.getText());
        String name = nameField.getText();
        double cgpa = Double.parseDouble(cgpaField.getText());
        Student student = new Student(id, name, cgpa);
*/

        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponents(label, button, waiverButton);

        verticalLayout.addComponent(horizontalLayout);
        verticalLayout.addComponents(studentForm, studentGrid);

        setContent(verticalLayout);
    }
}
