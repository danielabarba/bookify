package demo.books.service;

import demo.books.entity.Author;
import demo.books.entity.Book;
import demo.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import demo.books.repository.AuthorRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Component
public class AuthorService {
    //cambiar a service
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    static final String CORRECT_RECORD = "Correct record";
    static final String DELETED = "Deleted";
    static final String OLDER_AUTHOR = "The author must be 18 years or older";
    static final String AUTHOR_NAME = "The author name only have to have letters";
    static final String EMAIL = "The author Email have to be valid";
    static final String INVALID = "Invalid information";
    static final String NOT_FOUND = "Not found";
    static final String NOT_ID = "You have to set the ID";
    static final String NOT_VALID_AUTHOR = "Not valid author";
    static final String NOT_VALID_AUTHOR_BOOKS = "Books not found";
    public AuthorService() {

    }

    public String addAuthor(Author author){
        String response;

        try {
            if (author.getBornDate() == null){
                response = "{\"response\": \"Required born date \"}";
                return response;
            }
            LocalDate today
                    = LocalDate.now();
            Period period = Period.between(author.getBornDate(), today);

            if(period.getYears() < 18){
                response = "{\"response\": \"" + OLDER_AUTHOR + "\"}";

                return response;
            }

            if (author.getName() == null){
                response = "{\"response\": \"Required name \"}";
                return response;
            }
            else {
            boolean allLetters = author.getName().chars().allMatch(Character::isLetter);
            if(!allLetters){
                response = "{\"response\": \"" + AUTHOR_NAME + "\"}";

                return response;
            }
            }


            if (author.getEmail() == null){
                response = "{\"response\": \"Required email \"}";
                return response;
            }
            else {

            Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
            Matcher mat = pattern.matcher(author.getEmail());
            if(!mat.matches()){
                response = "{\"response\": \"" + EMAIL + "\"}";
                return response;
            }
            }

            try {
                URL url = new URL(author.getUrl());
                url.toURI();
            }
            catch (Exception e){
                response = "{\"response\": \"" + e.toString() + "\"}";
                return response;
            }


            try {
                authorRepository.save(author);
                response = "{\"response\": \"" + CORRECT_RECORD + " " + author.getName() + " " + author.getLastName()+ "\"}";
                return response;
            } catch (Exception e) {
                System.out.println(e.toString());
                System.out.println(e.getMessage().toString());
                System.out.println(e.getMessage());
                response = "{\"response\": \"" + INVALID + "\"}";
                return response;
            }


        }
        catch (Exception e){
            response = "{\"response\": \"" + e.toString() + "\"}";
            return response;
        }

    }
    public List<Author> getAuthor(){
        return   StreamSupport.stream(authorRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public String getAuthorById(Integer id){
        String response;
        try {
            Optional<Author> author = authorRepository.findById(id);
            response = "{\"response\": \"" + author.get().getName() + " " + author.get().getLastName() + "\"}";
            return response;
        }
        catch (Exception e){
            response = "{\"response\": \"" + NOT_FOUND + "\"}";

            return response;
        }
    }

    public String deleteById(Integer id){
        String response;

        try {
            if (authorRepository.existsById(id)){
                authorRepository.deleteById(id);
                response = "{\"response\": \" Author " + id + " "  + DELETED + "\"}";
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
    public String updateAuthor(Author author){
        String response;

        try {

            if (author.getId() == null){
                response = "{\"response\": \"" + NOT_ID + "\"}";
                return response;
            }
            if (author.getName() != null){
                boolean allLetters = author.getName().chars().allMatch(Character::isLetter);
                if(!allLetters){
                    response = "{\"response\": \"" + AUTHOR_NAME + "\"}";

                    return response;
                }

            }
            if(author.getBornDate() !=null){
                LocalDate today
                        = LocalDate.now();
                Period period = Period.between(author.getBornDate(), today);

                if(period.getYears() < 18){
                    response = "{\"response\": \"" + OLDER_AUTHOR + "\"}";

                    return response;
                }
            }

            if (author.getEmail() != null){
                Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
                Matcher mat = pattern.matcher(author.getEmail());
                if(!mat.matches()){
                    response = "{\"response\": \"" + EMAIL + "\"}";
                    return response;
                }
            }

            Optional<Author> byId = authorRepository.findById(author.getId());
            if (byId.isEmpty()){
                response = "{\"response\": \"" + NOT_VALID_AUTHOR + "\"}";
                return response;
            }

            authorRepository.save(author);
            response = "{\"response\": \"" + CORRECT_RECORD + "\"}";
            return response;
        }
        catch (Exception e){
            response = "{\"response\": \"" + e.toString() + "\"}";
            return response;
        }
    }

    public String getAuthorBooks(Integer id){
        String response;
        try {
            List<Book> byAuthorId = bookRepository.findByAuthorId(id);
            response = "[ \n" ;

            for (final Book oneBook : byAuthorId) {

                response = response  + "{\n\"id\": \"" + oneBook.getId() + "\",\n";
                response = response  + "\"Name\": \"" + oneBook.getName() + "\"\n},\n";
            }
            response = response.substring(0, response.length() - 2);

            response = response + "\n]" ;
            return response;

        }
        catch (Exception e){
            response = "{\"response\": \"" + NOT_VALID_AUTHOR_BOOKS + "\"}";
            return response;
        }

    }
}
