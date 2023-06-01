package demo.books.Application;

import demo.books.Repository.BookRepository;
import demo.books.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class BookApplication {


    @Autowired
    private BookRepository bookRepository;
    public BookApplication() {

    }

    public String addBook(Book book){
        System.out.println("helloou");
        System.out.println(book);
        try {
            bookRepository.save(book);
            return "Registro correcto";
        }
        catch (Exception e){
            return e.toString();
        }


    }

    public String getBook(){
        System.out.println(bookRepository.findAll());
        return null;
    }

    public String updateBook(Book book){

        try {
            bookRepository.save(book);
            return "Actualización correcta";
        }
        catch (Exception e){
            return e.toString();
        }
    }
}
