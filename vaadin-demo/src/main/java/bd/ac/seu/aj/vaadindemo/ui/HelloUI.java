package bd.ac.seu.aj.vaadindemo.ui;

import bd.ac.seu.aj.vaadindemo.model.Student;
import bd.ac.seu.aj.vaadindemo.service.StudentService;
import com.vaadin.annotations.Theme;
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

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Label label = new Label("Hello World");
        Button button = new Button("Click Me");
        Grid<Student> studentGrid = new Grid<>();
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

        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponents(label, button, waiverButton);

        verticalLayout.addComponent(horizontalLayout);
        verticalLayout.addComponent(studentGrid);

        setContent(verticalLayout);
    }
}
