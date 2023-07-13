package demo.books.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;



@Entity
@Table(name = "b_author")
public class Author {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Size(min = 3, max = 100, message
            = "About Me must be between 3 and 100 characters")
    @NotBlank(message = "Name is mandatory")
    @Column(unique = true)
    private String name;

    @Size(min = 3, max = 100, message
            = "Name must be between 3 and 100 characters")
    @NotNull
    private String lastName;

    private LocalDate bornDate;
    @Size(min = 50, max = 500, message
            = "Biography must be between 50 and 500 characters")
    @NotNull

    private String biography;

    @Size(min = 5, max = 50, message
            = "Nationality must be between 5 and 50 characters")
    @NotNull(message =  "Nationality is required")
    private String nationality;

    @NotNull(message =  "URL is required")
    @Column(unique = true)
    private String url;

    @NotNull(message =  "EMAIL is required")
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER , cascade={CascadeType.REMOVE,CascadeType.PERSIST})
    private List<Book> books;

    public Author() {

        books = Collections.emptyList();
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
    public  String getLastName(){
        return lastName;
    }
    public  LocalDate getBornDate(){
        return bornDate;
    }
    public   List<Book> getBooks(){
        return books;
    }
    public String getNationality() {return nationality;}
    public String getBiography() {return biography;}
    public String getUrl() {return url;}
    public String getEmail() {return email;}


    public  void setName(String name){
        this.name = name;
    }
    public  void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public  void setNationality(String nationality){
        this.nationality = nationality;
    }
    public  void setBiography(String biography){
        this.biography = biography;
    }
    public  void setUrl(String url){
        this.url = url;
    }
    public  void setEmail(String email){
        this.email = email;
    }

}
