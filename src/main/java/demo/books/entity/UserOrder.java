package demo.books.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Data
@Entity

@Table(name = "b_userOrder")
public class UserOrder {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

  //  @ManyToOne(fetch = FetchType.EAGER , cascade={CascadeType.REMOVE,CascadeType.MERGE})
    //@JoinColumn(name = "user_id")
    //private User user;

    private LocalDate date;
    private   ArrayList<Double> price;
    private   ArrayList<Integer> book;


    private Double total;

    public UserOrder(Integer id,   LocalDate date,    ArrayList<Double> price,    ArrayList<Integer> book, Double total) {

        this.id = id;
     //   this.user = user;
        this.date = date;
        this.total = total;
        this.price = price;
        this.book = book;


    }

    public UserOrder(){

    }
    public  Integer getId(){
        return id;
    }


    public  Double getTotal(){
        return total;
    }
    public    ArrayList<Double> getPrice(){
        return price;
    }
    public   ArrayList<Integer> getBook(){
        return book;
    }
    public  LocalDate getDate(){
        return date;
    }
  //  public User getUser(){
     //   return user;
    //}

    public void setId(Integer id) {
        this.id = id;
    }
//    public void setUser(User user) {
  //      this.user = user;
    //}

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setPrice(  ArrayList<Double> price) {
        this.price = price;
    }
    public void setBook(  ArrayList<Integer> book) {
        this.book = book;
    }


}
