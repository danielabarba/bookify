package demo.books.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import demo.books.Repository.UserRepository;
import demo.books.models.User;

@Component
public class UserApplication {
    @Autowired
    private UserRepository userRepository;
    public UserApplication() {

    }

    public String add(User user){
        try {
            userRepository.save(user);
            return "Registro correcto";
        }
        catch (Exception e){
            return e.toString();
        }


    }

    public String get(){
        System.out.println(userRepository.findAll());
        return null;
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
