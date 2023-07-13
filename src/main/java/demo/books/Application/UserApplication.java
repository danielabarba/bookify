package demo.books.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import demo.books.Repository.UserRepository;
import demo.books.Entity.User;
import org.springframework.util.Assert;

import java.util.Optional;

@Component
public class UserApplication {
    @Autowired
    private UserRepository userRepository;
    public UserApplication() {

    }

    public String add(User user){

        try {


            System.out.println(userRepository.save(user));
            return "Correct record";
        }
        catch (Exception e){
            return e.toString();
        }

    }

    public void get(){
        System.out.println(userRepository.findAll());

    }

    public String update(User user){

        try {
            userRepository.save(user);
            return "Actualización correcta";
        }
        catch (Exception e){
            return e.toString();
        }
    }
}
