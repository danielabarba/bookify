package demo.books.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "b_user")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Size(min = 3, max = 100, message
            = "About Me must be between 3 and 100 characters")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Size(min = 3, max = 100, message
            = "About Me must be between 3 and 100 characters")
    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    //  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER , cascade={CascadeType.REMOVE,CascadeType.PERSIST})
    //private List<User> users;

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
    public  String getLastName(){
        return lastName;
    }
    public  LocalDate getBornDate(){
        return bornDate;
    }

    // public List<User> getUsers(){ return users;}

    public  void setName(String name){
        this.name = name;
    }
    public  void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }
    //  public void setUsers(List<User> users) {this.users = users;}
}
