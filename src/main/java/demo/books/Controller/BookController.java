package demo.books.Controller;

import demo.books.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import demo.books.Application.BookApplication;

@RestController
@RequestMapping(value = "/book")

public class BookController {

    @Autowired
    private BookApplication bookApplication;

    @PostMapping(value = "/")
    public String create(@RequestBody Book newBook)
    {
      return bookApplication.addBook(newBook);
    }
    @PutMapping(value = "/")
    public String update(@RequestBody Book newBook)
    {
        return bookApplication.updateBook(newBook);
    }

    @GetMapping(value = "/")
    public void getPatient()
    {
        bookApplication.getBook();
    }
}
