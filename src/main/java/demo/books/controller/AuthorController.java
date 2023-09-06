package demo.books.controller;

import demo.books.service.AuthorService;
import demo.books.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")

public class AuthorController {
    @Autowired
    private AuthorService authorApplication;

    @PostMapping(value = "")
    public String create(@RequestBody Author newAuthor)
    {
        return authorApplication.addAuthor(newAuthor);
    }
    @PutMapping(value = "")
    public String update(@RequestBody Author author)
    {
        return authorApplication.updateAuthor(author);
    }

    @GetMapping(value = "")
    public List<Author> get()
    {
        return authorApplication.getAuthor();
    }

    @GetMapping(value = "/{id}")
    public String getById(@PathVariable Integer id)
    {
       return authorApplication.getAuthorById(id);
    }

    @GetMapping(value = "/{id}/books")
    public String getBooksById(@PathVariable Integer id)
    {
        return authorApplication.getAuthorBooks(id);
    }
    @DeleteMapping(value = "/{id}")
    public String deleteById(@PathVariable Integer id)
    {
        return authorApplication.deleteById(id);
    }
}
