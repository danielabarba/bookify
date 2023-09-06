package demo.books.service;

import demo.books.entity.Book;
import demo.books.repository.BookRepository;
import demo.books.repository.UserOrderRepository;
import demo.books.entity.UserOrder;
import demo.books.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UserOrderService {
    @Autowired
    private UserOrderRepository userOrderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private Optional<Book> book;
    public UserOrderService() {

    }
    static final String CORRECT_RECORD = "Correct record";
    static final String INCORRECT_RECORD = "Incorrect record";
    static final String NOT_FOUND = "Not found";

    static final String MISS_ID = "You have to set the ID";
    static final String DELETED = "Deleted";
    static final String BOOK = "Set book ID";
    public String add(UserOrder userOrder){
        String response;
        LocalDate today = LocalDate.now();
        Double total = 0.0;

        if (userOrder.getBook()== null){
            response = "{\"response\": \"" + BOOK + "\"}";
            return response;
        }
        try {
            for (int i=0;i<userOrder.getBook().size();i++) {

                book = bookRepository.findById(userOrder.getBook().get(i));
                if(book.isEmpty()){
                    response = "{\"response\": \"Book " + userOrder.getBook().get(i) +  " not found"  + "\"}";
                    return response;
                }

                total = total + book.get().getPrice();

            }

            userOrder.setDate(today);
            userOrder.setTotal(total);

        }
        catch (Exception e){
            response = "{\"response\": \"" + BOOK +  " " + userOrder.getDate() + "\"}";
            return response;
        }

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

    public String getById(Integer id){
        String response;
        try {
            Optional<UserOrder> userOrder = userOrderRepository.findById(id);
            response = "{\"response\": \"" + userOrder.get().getDate() +  "\"}";
            return response;
        }
        catch (Exception e){
            response = "{\"response\": \"" + "Not found" + "\"}";
            return response;
        }
    }

    public String update(UserOrder userOrder){
        String response;
        Double total = 0.0;

        if (userOrder.getId()== null){
            response = "{\"response\": \"" + MISS_ID + "\"}";
            return response;
        }
        if (userOrder.getBook()== null){
            response = "{\"response\": \"" + BOOK + "\"}";
            return response;
        }
        try {
            for (int i=0;i<userOrder.getBook().size();i++) {

                book = bookRepository.findById(userOrder.getBook().get(i));
                if(book.isEmpty()){
                    response = "{\"response\": \"Book " + userOrder.getBook().get(i) +  " not found"  + "\"}";
                    return response;
                }

                total = total + book.get().getPrice();

            }


            userOrder.setTotal(total);

        }
        catch (Exception e){
            response = "{\"response\": \"" + BOOK +  " " + userOrder.getId() + "\"}";
            return response;
        }

        try {

            userOrderRepository.save(userOrder);
            response = "{\"response\": \"" + CORRECT_RECORD +  " " + userOrder.getId()+ "\"}";
            return response;

        }
        catch (Exception e){
            response = "{\"response\": \"" + INCORRECT_RECORD + "\"}";
            return response;
        }
    }

    public String deleteById(Integer id){
        String response;
        try {
            if (userOrderRepository.existsById(id)){
                userOrderRepository.deleteById(id);
                response = "{\"response\": \"" + DELETED + " " + id + "\"}";
                return response;
            }
            {
                response = "{\"response\": \"" + NOT_FOUND + "\"}";
                return response;
            }

        }
        catch (Exception e){
            response = "{\"response\": \"" + e.toString() + "\"}";
            return response;
        }
    }
}
