package demo.books.controller;

import demo.books.service.UserApplication;
import demo.books.entity.User;
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
