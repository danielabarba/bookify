package demo.books.service;

import demo.books.repository.BookRepository;
import demo.books.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class BookApplication {


    @Autowired
    private BookRepository bookRepository;
    static final String CORRECT_RECORD = "Correct record";
    static final String INCORRECT_RECORD = "Incorrect record";
    static final String NEGATIVE_PRICE = "Price cant be negative";
    static final String NEGATIVE_STOCK = "Stock cant be negative";
    static final String MISS_ID = "You have to set the ID";
    static final String NOT_FOUND = "Not found";
    public BookApplication() {

    }

    public String addBook(Book book){
        String response;


        if(book.getPrice()<0){
            response = "{\"response\": \"" + NEGATIVE_PRICE + "\"}";

            return response;
        }

        if(book.getStock()<0){
            response = "{\"response\": \"" + NEGATIVE_STOCK + "\"}";

            return response;
        }


        try {
            bookRepository.save(book);
            response = "{\"response\": \"" + CORRECT_RECORD + "\"}";
            return response;
        }
        catch (Exception e){
            response = "{\"response\": \"" + e.toString() + "\"}";
            return response;
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
        String response;

        try {
            bookRepository.save(book);
            response = "{\"response\": \"" + CORRECT_RECORD + "\"}";
            return response;
        }
        catch (Exception e){
            response = "{\"response\": \"" + e.toString() + "\"}";
            return response;
        }
    }

    public String getById(Integer id){
        String response;
        try {
            Optional<Book> book = bookRepository.findById(id);
            System.out.println(book);
            return book.get().getName();
        }
        catch (Exception e){
            response = "{\"response\": \"" + NOT_FOUND + "\"}";
            return response;
        }
    }

    public String deleteById(Integer id){
        String response;
        try {
            if (bookRepository.existsById(id)){
                bookRepository.deleteById(id);
                response = "{\"response\": \"" + CORRECT_RECORD + "\"}";
                return response;
            }
            {
                response = "{\"response\": \"" + NOT_FOUND + "\"}";
                return response;
            }

        }
        catch (Exception e){
            response = "{\"response\": \"" + e.toString() + "\"}";
            return response;
        }
    }
}
