package demo.books.Controller;

import demo.books.Application.UserOrderApplication;
import demo.books.Entity.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class UserOrderController {
    @Autowired
    private UserOrderApplication userOrderApplication;

    @PostMapping(value = "/")
    public String create(@RequestBody UserOrder newUserOrder)
    {
        return userOrderApplication.add(newUserOrder);
    }
    @PutMapping(value = "/")
    public String update(@RequestBody UserOrder newUserOrder)
    {
        return userOrderApplication.update(newUserOrder);
    }

    @GetMapping(value = "/")
    public List<UserOrder> getPatient()
    {
        return userOrderApplication.get();
    }
}
