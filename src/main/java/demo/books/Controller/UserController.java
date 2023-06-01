package demo.books.Controller;

import demo.books.Application.UserApplication;
import demo.books.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserApplication userApplicationApplication;

    @PostMapping(value = "/")
    public String create(@RequestBody User nerUser)
    {
        return userApplicationApplication.add(nerUser);
    }
    @PutMapping(value = "/")
    public String update(@RequestBody User nerUser)
    {
        return userApplicationApplication.update(nerUser);
    }

    @GetMapping(value = "/")
    public void getPatient()
    {
        userApplicationApplication.get();
    }
}
