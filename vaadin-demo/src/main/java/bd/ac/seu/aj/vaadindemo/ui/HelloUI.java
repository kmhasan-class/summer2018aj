package bd.ac.seu.aj.vaadindemo.ui;

import bd.ac.seu.aj.vaadindemo.model.Student;
import bd.ac.seu.aj.vaadindemo.service.StudentService;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ComponentRenderer;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringUI
@Theme("valo")
public class HelloUI extends UI {
    private StudentService studentService;
    private StudentForm studentForm;

    public HelloUI(StudentService studentService) {
        super();
        this.studentService = studentService;
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
        studentGrid.addColumn(student -> {
            HorizontalLayout actionBar = new HorizontalLayout();

            Button editButton = new Button();
            editButton.setIcon(VaadinIcons.EDIT);
            editButton.addClickListener(clickEvent -> studentForm.setStudent(student));

            Button deleteButton = new Button();
            deleteButton.setIcon(VaadinIcons.CLOSE);

            actionBar.addComponents(editButton, deleteButton);

            return actionBar;
        }).setRenderer(new ComponentRenderer()).setCaption("Actions");

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

        studentForm = new StudentForm();

        HorizontalLayout toolBar = new HorizontalLayout();

        Button resetButton = new Button("Reset");
        resetButton.setIcon(VaadinIcons.REFRESH);
        resetButton.addClickListener(clickEvent -> studentForm.setStudent(new Student()));

        Button saveButton = new Button("Save");
        saveButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
        saveButton.setIcon(VaadinIcons.FILE_ADD);
        saveButton.addClickListener(clickEvent -> {
            studentForm.getStudent().ifPresent(studentService::saveStudent);
        });

        toolBar.addComponents(resetButton, saveButton);


        verticalLayout.addComponent(horizontalLayout);
        verticalLayout.addComponents(studentForm, toolBar, studentGrid);

        setContent(verticalLayout);
    }
}
