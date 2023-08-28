package demo.books.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import demo.books.entity.Book;
@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {
}
