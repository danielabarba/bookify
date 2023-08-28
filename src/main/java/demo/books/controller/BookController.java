package demo.books.controller;

import demo.books.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import demo.books.service.BookApplication;

import java.util.List;

@RestController
@RequestMapping(value = "/books")

public class BookController {

    @Autowired
    private BookApplication bookApplication;

    @PostMapping(value = "")
    public String create(@RequestBody Book newBook)
    {
      return bookApplication.addBook(newBook);
    }
    @PutMapping(value = "")
    public String update(@RequestBody Book newBook)
    {
        return bookApplication.updateBook(newBook);
    }

    @GetMapping(value = "")
    public List<Book> getPatient()
    {
        return bookApplication.getBook();
    }

    @GetMapping(value = "/{id}")
    public String getById(@PathVariable Integer id)
    {
        return bookApplication.getById(id);
    }
    @DeleteMapping(value = "/{id}")
    public String deleteById(@PathVariable Integer id)
    {
        return bookApplication.deleteById(id);
    }
}
