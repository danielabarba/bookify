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
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    private String name;
    //Separar los nombres

    private LocalDate bornDate;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;

    }


    public  String getName(){
        return name;
    }
    public  LocalDate getBornDate(){
        return bornDate;
    }


    public  void setName(String name){
        this.name = name;
    }
    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }
}
