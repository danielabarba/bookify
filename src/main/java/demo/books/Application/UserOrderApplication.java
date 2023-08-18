package demo.books.Application;

import demo.books.Entity.Author;
import demo.books.Entity.User;
import demo.books.Repository.UserOrderRepository;
import demo.books.Entity.UserOrder;
import demo.books.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UserOrderApplication {
    @Autowired
    private UserOrderRepository userOrderRepository;
    @Autowired
    private UserRepository userRepository;
    public UserOrderApplication() {

    }

    public String add(UserOrder userOrder){
        try {
       //     Optional<User> byIdUser = userRepository.findById(userOrder.getUser().getId());
          //  System.out.println(byIdUser);
            //Assert.state(!byIdUser.isEmpty(), "Not valid user");
            userOrderRepository.save(userOrder);
            return "Correct record";
        }
        catch (Exception e){
            return e.toString();
        }


    }

    public List<UserOrder> get(){

        return StreamSupport.stream(userOrderRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public String update(UserOrder userOrder){

        try {
            Assert.state(userOrder.getId() != null, "You have to set the ID");

       //     Optional<UserOrder> byIdUser = userOrderRepository.findById(userOrder.getId());
         //   Assert.state(byIdUser.isPresent(), "Not valid user Order");
            userOrderRepository.save(userOrder);
            return "Done";
        }
        catch (Exception e){
            return e.toString();
        }
    }
}
