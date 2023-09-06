package demo.books.service;

import demo.books.entity.Book;
import demo.books.repository.BookRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class BookServiceTest {
    @Autowired
    BookService bookService = new BookService();
    @Autowired
    Book book = new Book();
    @Autowired
    BookRepository bookRepository = new BookRepository() {
        @Override
        public List<Book> findByAuthorId(Integer id) {
            return null;
        }

        @Override
        public <S extends Book> S save(S s) {
            return null;
        }

        @Override
        public <S extends Book> Iterable<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public Optional<Book> findById(Integer integer) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Integer integer) {
            return false;
        }

        @Override
        public Iterable<Book> findAll() {
            return null;
        }

        @Override
        public Iterable<Book> findAllById(Iterable<Integer> iterable) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Integer integer) {

        }

        @Override
        public void delete(Book book) {

        }

        @Override
        public void deleteAll(Iterable<? extends Book> iterable) {

        }

        @Override
        public void deleteAll() {

        }
    };

    @Test
    public void addBookTest(){
        book.setName("aev");
        book.setPrice(3.0);
        book.setIsbn(3445);
        book.setStock(3);
        book.setAuthorId(1);
        bookService.addBook(book);
    }
    @Test
    public void addBookTestWithOutPrice(){
        book.setName("aev");
        book.setIsbn(3445);
        book.setStock(3);
        book.setAuthorId(1);
        bookService.addBook(book);
    }
    @Test
    public void addBookTestWithoutStock(){
        book.setName("aev");
        book.setPrice(3.0);
        book.setIsbn(3445);
        book.setAuthorId(1);
        bookService.addBook(book);
    }
    @Test
    public void addBookTestWithoutISBN(){
        book.setName("aev");
        book.setPrice(3.0);
        book.setStock(3);
        book.setAuthorId(1);
        bookService.addBook(book);
    }
    @Test
    public void addBookTestWithout(){
        book.setName("aev");
        book.setPrice(3.0);
        book.setIsbn(3445);
        book.setStock(3);
        book.setAuthorId(1);
        bookService.addBook(book);
    }
    @Test
    public void addBookTestWithoutAuthor(){
        book.setName("aev");
        book.setPrice(3.0);
        book.setIsbn(3445);
        book.setStock(3);
        bookService.addBook(book);
    }

    @Test
    public void addBookTestWithNegativePrice(){
        book.setName("aev");
        book.setPrice(-1.0);
        book.setIsbn(3445);
        book.setStock(3);
        book.setAuthorId(1);
        bookService.addBook(book);
    }
    @Test
    public void addBookTestWithNegativeStock(){
        book.setName("aev");
        book.setPrice(3.0);
        book.setIsbn(3445);
        book.setStock(-3);
        book.setAuthorId(1);
        bookService.addBook(book);
    }

    @Test
    public void updateBookTest(){
        book.setId(1);
        book.setName("aev");
        book.setPrice(3.0);
        book.setIsbn(3445);
        book.setStock(3);
        book.setAuthorId(1);
        bookService.updateBook(book);
    }
    @Test
    public void updateBookTestNegativeStock(){
        book.setId(1);
        book.setName("aev");
        book.setPrice(3.0);
        book.setIsbn(3445);
        book.setStock(-3);
        book.setAuthorId(1);
        bookService.updateBook(book);
    }
    @Test
    public void updateBookTestNegativePrice(){
        book.setId(1);
        book.setName("aev");
        book.setPrice(-3.0);
        book.setIsbn(3445);
        book.setStock(3);
        book.setAuthorId(1);
        bookService.updateBook(book);
    }
    @Test
    public void updateBookTestNegativeMissId(){
        book.setName("aev");
        book.setPrice(-3.0);
        book.setIsbn(3445);
        book.setStock(3);
        book.setAuthorId(1);
        bookService.updateBook(book);
    }
    @Test
    public void getByIdTest(){
        bookService.getById(1);
    }
    @Test
    public void deleteByIdTest(){
        bookService.deleteById(1);
    }
}
