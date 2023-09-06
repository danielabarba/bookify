package demo.books.entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import static javax.persistence.GenerationType.IDENTITY;


@Data
@Entity
@Table(name = "b_book")
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @NotBlank(message = "Name of the book is mandatory")
    @Size(min = 3, max = 100, message
            = "About Me must be between 3 and 100 characters")
    private String name;

    private Integer authorId;

    private LocalDate publicationDate;

    //@Column(message = "Price is mandatory")
    @NotNull(message =  "Price is required")

    private Double price;

    @NotNull(message =  "Stock is required")
    private Integer stock;

    @NotNull(message =  "ISBN is required")
    @Column(unique = true)
    private Number isbn;


    public Book(Integer id, String name, Integer authorId, LocalDate publicationDate, Double price, Number isbn, Integer stock) {

        this.id = id;
        this.name = name;
        this.publicationDate = publicationDate;
        this. price = price;
        this.isbn = isbn;
        this.stock = stock;
        this.authorId = authorId;

    }
    public Book() {

    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;

    }


    public  String getName(){
        return name;
    }
    public  LocalDate getPublicationDate(){
        return publicationDate;
    }
    public  Double getPrice(){
        return price;
    }
    public  Number getIsbn(){
        return isbn;
    }
    public  Integer getStock(){
        return stock;
    }
    public  Integer getAuthorID(){
        return authorId;
    }


    public  void setName(String name){
        this.name = name;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setIsbn(Number isbn) {
        this.isbn = isbn;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
}