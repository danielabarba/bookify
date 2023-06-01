package demo.books.Application;

import demo.books.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import demo.books.Repository.AuthorRepository;

@Component
public class AuthorApplication {

    @Autowired
    private AuthorRepository authorRepository;
    public AuthorApplication() {

    }

    public String addAuthor(Author author){
        try {
            authorRepository.save(author);
            return "Registro correcto";
        }
        catch (Exception e){
            return e.toString();
        }

    }
    public String getAuthor(){
        System.out.println(authorRepository.findAll());
        return null;
    }
    public String updateAuthor(Author author){

        try {
            authorRepository.save(author);
            return "Actualización correcta";
        }
        catch (Exception e){
            return e.toString();
        }
    }
}
