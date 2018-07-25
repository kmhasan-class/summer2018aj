package bd.ac.seu.aj.springbootdemo.repository;

import bd.ac.seu.aj.springbootdemo.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    public Student findStudentByName(String name);
}
