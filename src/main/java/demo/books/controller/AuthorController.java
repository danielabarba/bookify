package demo.books.controller;

import demo.books.service.AuthorApplication;
import demo.books.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/authors")

public class AuthorController {
    @Autowired
    private AuthorApplication authorApplication;

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
    public void get()
    {
        authorApplication.getAuthor();
    }

    @GetMapping(value = "/{id}")
    public String getById(@PathVariable Integer id)
    {
       return authorApplication.getAuthorById(id);
    }
    @DeleteMapping(value = "/{id}")
    public String deleteById(@PathVariable Integer id)
    {
        return authorApplication.deleteById(id);
    }
}
