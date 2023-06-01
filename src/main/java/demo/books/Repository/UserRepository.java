package demo.books.Repository;

import org.springframework.data.repository.CrudRepository;
import demo.books.models.User;

public interface UserRepository extends CrudRepository<User,Integer> {

}
