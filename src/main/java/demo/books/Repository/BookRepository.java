package demo.books.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import demo.books.Entity.Book;
@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {
}
