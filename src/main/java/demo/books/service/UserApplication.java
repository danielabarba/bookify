package demo.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import demo.books.repository.UserRepository;
import demo.books.entity.User;

@Component
public class UserApplication {
    @Autowired
    private UserRepository userRepository;
    static final String CORRECT_RECORD = "Correct record";
    static final String INCORRECT_RECORD = "Incorrect record";
    static final String UPDATED = "Updated";
    public UserApplication() {

    }

    public String add(User user){
        String response;

        try {
            userRepository.save(user);
            response = "{\"response\": \"" + CORRECT_RECORD + "\"}";
            return response;
        }
        catch (Exception e){
            response = "{\"response\": \"" + e.toString() + "\"}";
            return response;
        }

    }

    public void get(){
        System.out.println(userRepository.findAll());

    }

    public String update(User user){
        String response;

        try {
            userRepository.save(user);
            response = "{\"response\": \"" + UPDATED + "\"}";
            return response;
        }
        catch (Exception e){
            response = "{\"response\": \"" + e.toString() + "\"}";
            return response;
        }
    }
}
