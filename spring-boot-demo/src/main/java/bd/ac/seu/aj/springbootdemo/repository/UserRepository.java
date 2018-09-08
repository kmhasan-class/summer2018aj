package bd.ac.seu.aj.springbootdemo.repository;

import bd.ac.seu.aj.springbootdemo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
