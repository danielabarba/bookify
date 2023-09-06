package demo.books.service;

import demo.books.entity.UserOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserOrderServiceTest {
    @Autowired
    UserOrderService userOrderService = new UserOrderService();
    @Autowired
    UserOrder userOrder = new UserOrder();
    @Test
    public void addTest(){
        ArrayList<Integer> books = new ArrayList<>();
        books.add(1);
        userOrder.setBook(books);
        userOrderService.add(userOrder);
    }
    @Test
    public void addTestNullBook(){
        userOrder.setId(1);
        userOrderService.add(userOrder);
    }

    @Test
    public void getByIdTest(){
        userOrderService.deleteById(1);
    }

    @Test
    public void updateTest(){
        ArrayList<Integer> books = new ArrayList<>();
        books.add(1);
        userOrder.setBook(books);
        userOrderService.update(userOrder);
    }

    @Test
    public void deleteById(){
        ArrayList<Integer> books = new ArrayList<>();
        books.add(1);
        userOrder.setBook(books);
        userOrderService.deleteById(1);
    }
}
