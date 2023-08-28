package demo.books.service;

import demo.books.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import demo.books.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthorApplication {
    //cambiar a service
    @Autowired
    private AuthorRepository authorRepository;
    static final String CORRECT_RECORD = "Correct record";
    static final String INCORRECT_RECORD = "Incorrect record";
    static final String UPDATED = "Updated";
    static final String DELETED = "Deleted";
    static final String OLDER_AUTHOR = "The author must be 18 years or older";
    static final String AUTHOR_NAME = "The author name only have to have letters";
    static final String EMAIL = "The author Email have to be valid";
    static final String INVALID_URL = "Invalid URL";
    static final String NOT_FOUND = "Not found";
    static final String NOT_ID = "You have to set the ID";
    static final String NOT_VALID_AUTHOR = "Not valid author";
    public AuthorApplication() {

    }

    public String addAuthor(Author author){
        String response;

        try {
            LocalDate today
                    = LocalDate.now();
            Period period = Period.between(author.getBornDate(), today);

            if(period.getYears() < 18){
                response = "{\"response\": \"" + OLDER_AUTHOR + "\"}";

                return response;
            }


            boolean allLetters = author.getName().chars().allMatch(Character::isLetter);
            if(!allLetters){
                response = "{\"response\": \"" + AUTHOR_NAME + "\"}";

                return response;
            }

            Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
            Matcher mat = pattern.matcher(author.getEmail());
            if(!mat.matches()){
                response = "{\"response\": \"" + EMAIL + "\"}";
                return response;
            }


            try {
                URL url = new URL(author.getUrl());
                url.toURI();
                authorRepository.save(author);
                response = "{\"response\": \"" + CORRECT_RECORD + "\"}";
                return response;
            } catch (Exception e) {
                response = "{\"response\": \"" + INVALID_URL + "\"}";
                return response;
            }


        }
        catch (Exception e){
            response = "{\"response\": \"" + e.toString() + "\"}";
            return response;
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
        String response;
        try {
            Optional<Author> author = authorRepository.findById(id);

            return author.get().getName();
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
                response = "{\"response\": \"" + DELETED + "\"}";
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
}
