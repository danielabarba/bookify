package demo.books.service;

import demo.books.entity.Author;
import demo.books.repository.AuthorRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Component
@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
    @Autowired
    private AuthorService authorService = new AuthorService();
    @Autowired
    private Author author = new Author();
    @Autowired
    private AuthorRepository authorRepository = new AuthorRepository() {
        @Override
        public <S extends Author> S save(S s) {
            return null;
        }

        @Override
        public <S extends Author> Iterable<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public Optional<Author> findById(Integer integer) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Integer integer) {
            return false;
        }

        @Override
        public Iterable<Author> findAll() {
            return null;
        }

        @Override
        public Iterable<Author> findAllById(Iterable<Integer> iterable) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Integer integer) {

        }

        @Override
        public void delete(Author author) {

        }

        @Override
        public void deleteAll(Iterable<? extends Author> iterable) {

        }

        @Override
        public void deleteAll() {

        }
    };

    @Test
    public void addAuthorTestPass(){
        author.setName("Daniela");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setLastName("Barba");
        author.setBornDate(LocalDate.parse("1994-01-11"));
        author.setNationality("Mexicana");
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        author.setEmail("danigeaa@gmail.com");
        authorService.addAuthor(author);
    }

    @Test
    public void addAuthorTestMissingName(){
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setLastName("Barba");
        author.setBornDate(LocalDate.parse("1994-01-11"));
        author.setNationality("Mexicana");
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        author.setEmail("danigeaa@gmail.com");
        authorService.addAuthor(author);
    }


    @Test
    public void addAuthorTestPassMissingLastname(){
        author.setName("Daniela");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setBornDate(LocalDate.parse("1994-01-11"));
        author.setNationality("Mexicana");
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        author.setEmail("danigeaa@gmail.com");
        authorService.addAuthor(author);
    }

    @Test
    public void addAuthorTestPassMissingBriography(){
        author.setName("Daniela");
        author.setLastName("Barba");
        author.setBornDate(LocalDate.parse("1994-01-11"));
        author.setNationality("Mexicana");
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        author.setEmail("danigeaa@gmail.com");
        authorService.addAuthor(author);
    }

    @Test
    public void addAuthorTestPassMissingBornDate(){
        author.setName("Daniela");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setLastName("Barba");
        author.setNationality("Mexicana");
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        author.setEmail("danigeaa@gmail.com");
        authorService.addAuthor(author);
    }

    @Test
    public void addAuthorTestPassWrongBornDate(){
        author.setName("Daniela");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setBornDate(LocalDate.parse("2020-01-11"));

        author.setLastName("Barba");
        author.setNationality("Mexicana");
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        author.setEmail("danigeaa@gmail.com");
        authorService.addAuthor(author);
    }
    @Test
    public void addAuthorTestPassWrongName(){
        author.setName("Daniel3a");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setBornDate(LocalDate.parse("2000-01-11"));

        author.setLastName("Barba");
        author.setNationality("Mexicana");
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        author.setEmail("danigeaa@gmail.com");
        authorService.addAuthor(author);
    }
    @Test
    public void addAuthorTestPassWrongEmail(){
        author.setName("Daniela");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setBornDate(LocalDate.parse("2000-01-11"));

        author.setLastName("Barba");
        author.setNationality("Mexicana");
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        author.setEmail("danigeaa");
        authorService.addAuthor(author);
    }
    @Test
    public void addAuthorTestPassWrongURL(){
        author.setName("Daniela");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setBornDate(LocalDate.parse("2000-01-11"));

        author.setLastName("Barba");
        author.setNationality("Mexicana");
        author.setUrl("hwww");
        author.setEmail("danigeaa@gmail.com");
        authorService.addAuthor(author);
    }
    @Test
    public void addAuthorTestPassMissingNationality(){
        author.setName("Daniela");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setLastName("Barba");
        author.setBornDate(LocalDate.parse("1994-01-11"));
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        author.setEmail("danigeaa@gmail.com");
        authorService.addAuthor(author);
    }
    @Test
    public void addAuthorTestPassMissingUrl(){
        author.setName("Daniela");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setLastName("Barba");
        author.setBornDate(LocalDate.parse("1994-01-11"));
        author.setNationality("Mexicana");
        author.setEmail("danigeaa@gmail.com");
        authorService.addAuthor(author);
    }
    @Test
    public void addAuthorTestPassMissingEmail(){
        author.setName("Daniela");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setLastName("Barba");
        author.setBornDate(LocalDate.parse("1994-01-11"));
        author.setNationality("Mexicana");
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        authorService.addAuthor(author);
    }
    @Test
    public void getAuthorById(){
        authorService.getAuthorById(1);
    }
    @Test
    public void deleteAuthorById(){
        authorService.deleteById(1);
    }

    @Test
    public void updateAuthorTestPass(){
        author.setName("Daniela");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setLastName("Barba");
        author.setBornDate(LocalDate.parse("1994-01-11"));
        author.setNationality("Mexicana");
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        author.setEmail("danigeaa@gmail.com");
        author.setId(1);
        authorService.updateAuthor(author);
    }
    @Test
    public void updateAuthorTestMissingId(){
        author.setName("Daniela");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setLastName("Barba");
        author.setBornDate(LocalDate.parse("1994-01-11"));
        author.setNationality("Mexicana");
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        author.setEmail("danigeaa@gmail.com");
        authorService.updateAuthor(author);
    }
    @Test
    public void updateAuthorTestWrongName(){
        author.setName("Daniela3");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setLastName("Barba");
        author.setBornDate(LocalDate.parse("1994-01-11"));
        author.setNationality("Mexicana");
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        author.setEmail("danigeaa@gmail.com");
        author.setId(1);
        authorService.updateAuthor(author);
    }
    @Test
    public void updateAuthorTestWrongEmail(){
        author.setName("Daniela");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setLastName("Barba");
        author.setBornDate(LocalDate.parse("1994-01-11"));
        author.setNationality("Mexicana");
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        author.setEmail("danigea");
        author.setId(1);
        authorService.updateAuthor(author);
    }
    @Test
    public void updateAuthorTestWrongUrl(){
        author.setName("Daniela");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setLastName("Barba");
        author.setBornDate(LocalDate.parse("1994-01-11"));
        author.setNationality("Mexicana");
        author.setUrl("http");
        author.setEmail("danigeaa@gmail.com");
        author.setId(1);
        authorService.updateAuthor(author);
    }
    @Test
    public void updateAuthorTestWrongBirth(){
        author.setName("Daniela");
        author.setBiography("d,flf krfkr dfkrfkm feefvm");
        author.setLastName("Barba");
        author.setBornDate(LocalDate.parse("2020-01-11"));
        author.setNationality("Mexicana");
        author.setUrl("https://www.gouele.com/search?q=google&rlz=1C1VDKB_esMX1058MX1q=google&g");
        author.setEmail("danigeaa@gmail.com");
        author.setId(1);
        authorService.updateAuthor(author);
    }

    @Test
    public void getAuthorBooksTest(){
        authorService.getAuthorBooks(1);
    }


}
