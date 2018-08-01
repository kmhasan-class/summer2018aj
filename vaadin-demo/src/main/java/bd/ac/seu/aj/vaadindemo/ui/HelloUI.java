package bd.ac.seu.aj.vaadindemo.ui;

import bd.ac.seu.aj.vaadindemo.model.Student;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

@SpringUI
@Theme("valo")
public class HelloUI extends UI {
    private List<Student> studentList;

    public HelloUI() {
        // HW: instead of working with fake data, make sure that
        // the data is read from a web service
        studentList = new ArrayList<>();
        studentList.add(new Student(10, "Abul", 2.99));
        studentList.add(new Student(20, "Babul", 2.70));
        studentList.add(new Student(21, "Kabul", 3.21));
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Label label = new Label("Hello World");
        Button button = new Button("Click Me");
        Grid<Student> studentGrid = new Grid<>();
        studentGrid.setItems(studentList);
        studentGrid.addColumn(Student::getId).setCaption("Student ID");
        studentGrid.addColumn(Student::getName).setCaption("Student Name");
        studentGrid.addColumn(Student::getCgpa).setCaption("CGPA");

        button.addClickListener(clickEvent -> {
            label.setValue("AJ");
            Notification.show("Hello");
        });

        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(label);
        horizontalLayout.addComponent(button);

        verticalLayout.addComponent(horizontalLayout);
        verticalLayout.addComponent(studentGrid);

        setContent(verticalLayout);
    }
}
