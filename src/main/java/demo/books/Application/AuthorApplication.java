package demo.books.Application;

import demo.books.Entity.Author;
import demo.books.Entity.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import demo.books.Repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class AuthorApplication {
    //cambiar a service
    @Autowired
    private AuthorRepository authorRepository;
    public AuthorApplication() {

    }

    public String addAuthor(Author author){
        try {
            LocalDate today
                    = LocalDate.now();
            Period period = Period.between(author.getBornDate(), today);
            Assert.state(period.getYears() > 18, "\n" +
                    "The author must be 18 years or older" );

            boolean allLetters = author.getName().chars().allMatch(Character::isLetter);
            Assert.state(allLetters, "\n" +
                    "The author name only have to have letters" );

            Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
            Matcher mat = pattern.matcher(author.getEmail());
            Assert.state(mat.matches(), "\n" +
                    "The author Email have to be valid" );

            try {
                URL url = new URL(author.getUrl());
                url.toURI();
                authorRepository.save(author);
                return "Correct record";
            } catch (Exception e) {
                return "Invalid URL";
            }


        }
        catch (Exception e){
            return e.toString();
        }

    }
    public String getAuthor(){
        Iterable<Author> allAuthors = authorRepository.findAll();


        for (final Author one : allAuthors) {
            System.out.println(one.getName());
        }
        return null;
    }

    public String getAuthorById(Integer id){
        try {
            Optional<Author> author = authorRepository.findById(id);

            return author.get().getName();
        }
        catch (Exception e){
            return "Not found";
        }
    }

    public String deleteById(Integer id){

        try {
            if (authorRepository.existsById(id)){
                authorRepository.deleteById(id);
                return "Done";
            }
            {
                return "Author not found";
            }

        }
        catch (Exception e){
            return e.toString();
        }
    }
    public String updateAuthor(Author author){

        try {
            Assert.state(author.getId() != null, "You have to set the ID");

            Optional<Author> byId = authorRepository.findById(author.getId());
            Assert.state(!byId.isEmpty(), "Not valid author");
            authorRepository.save(author);
            return "Done";
        }
        catch (Exception e){
            return e.toString();
        }
    }
}
