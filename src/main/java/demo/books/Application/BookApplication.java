package demo.books.Application;

import demo.books.Entity.Author;
import demo.books.Repository.BookRepository;
import demo.books.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Component

public class BookApplication {


    @Autowired
    private BookRepository bookRepository;
    public BookApplication() {

    }

    public String addBook(Book book){

        System.out.println(book);

        Assert.state(book.getPrice() > 0, "\n" +
                "Price cant be negative" );


        Assert.state(book.getStock() > 0, "\n" +
                "Price cant be negative" );
        try {
            bookRepository.save(book);
            return "Registro correcto";
        }
        catch (Exception e){
            return e.toString();
        }


    }

    public List<Book> getBook(){

        Iterable<Book> allBooks = bookRepository.findAll();


        for (final Book one : allBooks) {
            System.out.println(one.getName());
        }
        return null;
    }

    public String updateBook(Book book){

        try {
            bookRepository.save(book);
            return "Update";
        }
        catch (Exception e){
            return e.toString();
        }
    }

    public String getById(Integer id){
        try {
            Optional<Book> book = bookRepository.findById(id);
            System.out.println(book);
            return book.get().getName();
        }
        catch (Exception e){
            return "Not found";
        }
    }

    public String deleteById(Integer id){

        try {
            if (bookRepository.existsById(id)){
                bookRepository.deleteById(id);
                return "Done";
            }
            {
                return "Author not found";
            }

        }
        catch (Exception e){
            return e.toString();
        }
    }
}
