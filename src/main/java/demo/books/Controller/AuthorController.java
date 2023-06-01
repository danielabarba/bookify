package demo.books.Controller;

import demo.books.Application.AuthorApplication;
import demo.books.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/author")

public class AuthorController {
    @Autowired
    private AuthorApplication authorApplication;

    @PostMapping(value = "/")
    public String create(@RequestBody Author newAuthor)
    {
        return authorApplication.addAuthor(newAuthor);
    }
    @PutMapping(value = "/")
    public String update(@RequestBody Author author)
    {
        return authorApplication.updateAuthor(author);
    }

    @GetMapping(value = "/")
    public void get()
    {
        authorApplication.getAuthor();
    }
}
