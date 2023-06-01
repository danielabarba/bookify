package demo.books.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


import static javax.persistence.GenerationType.IDENTITY;


@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    private String name;

    private String author;


    private LocalDate publicationDate;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;

    }

    public  String getAuthor(){
        return author;
    }
    public  String getName(){
        return name;
    }
    public  LocalDate getPublicationDate(){
        return publicationDate;
    }


    public  void setName(String name){
        this.name = name;
    }
    public  void setAuthor(String author){
        this.author = author;
    }
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
}
