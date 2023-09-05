package demo.books.service;


import demo.books.repository.BookRepository;
import demo.books.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class BookService {


    @Autowired
    private BookRepository bookRepository;

    static final String CORRECT_RECORD = "Correct record";
    static final String INCORRECT_RECORD = "Incorrect record";
    static final String PRICE = "Set price";
    static final String AUTHOR = "Set author";
    static final String STOCK = "Set stock";
    static final String ISBN = "Set ISBN";
    static final String NEGATIVE_PRICE = "Price cant be negative";
    static final String NEGATIVE_STOCK = "Stock cant be negative";
    static final String MISS_ID = "You have to set the ID";
    static final String NOT_FOUND = "Not found";
    static final String DELETED = "Deleted";
    public BookService() {

    }

    public String addBook(Book book){
        String response;

        if(book.getPrice() == null)
        {
            response = "{\"response\": \"" + PRICE + "\"}";
            return response;

        }

        if(book.getStock() == null)
        {
            response = "{\"response\": \"" + STOCK + "\"}";
            return response;

        }
        if(book.getIsbn() == null)
        {
            response = "{\"response\": \"" + ISBN + "\"}";
            return response;

        }

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
            response = "{\"response\": \"" + CORRECT_RECORD + " " + book.getName() + "\"}";
            return response;
        }
        catch (Exception e){
            response = "{\"response\": \"" + e.toString() + "\"}";
            return response;
        }


    }

    public String getBook(){

        Iterable<Book> allBooks = bookRepository.findAll();


        String response;
        response = "[ \n" ;

        for (final Book oneBook : allBooks) {

            response = response  + "{\n\"id\": \"" + oneBook.getId() + "\",\n";
            response = response  + "\"Name\": \"" + oneBook.getName() + "\"\n},\n";
        }
        response = response.substring(0, response.length() - 2);

        response = response + "\n]" ;
        return response;

    }

    public String updateBook(Book book){
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

    public String getById(Integer id){
        String response;
        try {
            Optional<Book> book = bookRepository.findById(id);
            response = "{\"response\": \"" + book.get().getName() +  "\"}";
            return response;
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
                response = "{\"response\": \"" + DELETED + " " + id + "\"}";
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
