package demo.books.repository;

import demo.books.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AuthorRepository extends CrudRepository<Author,Integer> {

    }
