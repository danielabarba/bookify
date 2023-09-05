package demo.books.service;

import demo.books.repository.UserOrderRepository;
import demo.books.entity.UserOrder;
import demo.books.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UserOrderService {
    @Autowired
    private UserOrderRepository userOrderRepository;
    @Autowired
    private UserRepository userRepository;
    public UserOrderService() {

    }
    static final String CORRECT_RECORD = "Correct record";
    static final String INCORRECT_RECORD = "Incorrect record";
    static final String MISS_ID = "You have to set the ID";
    static final String INVALID_USER = "You have to set the ID";
    public String add(UserOrder userOrder){
        String response;
        try {

            userOrderRepository.save(userOrder);
            response = "{\"response\": \"" + CORRECT_RECORD +  " " + userOrder.getDate() + "\"}";
            return response;

        }
        catch (Exception e){
            response = "{\"response\": \"" + INCORRECT_RECORD + "\"}";
            return response;
        }


    }

    public List<UserOrder> get(){

        return StreamSupport.stream(userOrderRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public String update(UserOrder userOrder){
        String response;

        try {
            if (userOrder.getId() == null){
                response = "{\"response\": \"" + MISS_ID + "\"}";
                return response;
            }

       //     Optional<UserOrder> byIdUser = userOrderRepository.findById(userOrder.getId());
         //   Assert.state(byIdUser.isPresent(), "Not valid user Order");
            userOrderRepository.save(userOrder);
            response = "{\"response\": \"" + CORRECT_RECORD + "\"}";
            return response;
        }
        catch (Exception e){
            response = "{\"response\": \"" + e.toString() + "\"}";
            return response;
        }
    }
}
