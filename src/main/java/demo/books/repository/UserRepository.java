package demo.books.repository;

import org.springframework.data.repository.CrudRepository;
import demo.books.entity.User;

public interface UserRepository extends CrudRepository<User,Integer> {

}
