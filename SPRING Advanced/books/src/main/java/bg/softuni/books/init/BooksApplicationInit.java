package bg.softuni.books.init;

import bg.softuni.books.model.entity.AuthorEntity;
import bg.softuni.books.model.entity.BookEntity;
import bg.softuni.books.model.entity.repository.AuthorRepo;
import bg.softuni.books.model.entity.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class BooksApplicationInit implements CommandLineRunner {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;

    @Autowired
    public BooksApplicationInit(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (bookRepo.count() == 0 && authorRepo.count() == 0) {
            initJovkov();
            initNikolayHaitov();
            initDimitarTalev();
            initElinPelin();
            initVazov();
        }
    }

    private void initVazov() {
        initAuthor("Иван Вазов", "Под Игото", "Тъгите на България");
    }

    private void initElinPelin() {
        initAuthor("Елин Пелин", "По Жътва", "Пижо и пенда");
    }

    private void initDimitarTalev() {
        initAuthor("Димитър Талев", "Железният светилник", "Тютюн");
    }

    private void initJovkov() {
        initAuthor("Йордан Йовков", "Старопланински легенди", "Чифликът край границата");
    }

    private void initNikolayHaitov() {
        initAuthor("Николай Хайтов", "Диви Разкази");
    }

    private void initAuthor(String authorName, String... books) {
        AuthorEntity author = new AuthorEntity();
        author.setName(authorName);

        List<BookEntity> allBooks = new ArrayList<>();

        for (String book : books) {
            BookEntity aBook = new BookEntity();
            aBook.setAuthor(author);
            aBook.setTitle(book);
            aBook.setIsbn(UUID.randomUUID().toString());
            allBooks.add(aBook);
        }

        author.setBook(allBooks);

        bookRepo.saveAll(allBooks);
    }


}
