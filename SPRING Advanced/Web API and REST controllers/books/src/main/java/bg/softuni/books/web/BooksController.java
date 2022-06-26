package bg.softuni.books.web;

import bg.softuni.books.model.entity.dto.BookDto;
import bg.softuni.books.service.BookService;
import org.aspectj.bridge.MessageUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    // called at http//:localhost::8080/books
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> allBooks = bookService.getAllBooks();

        return ResponseEntity.ok(allBooks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long id){

        Optional<BookDto> bookById = bookService.findBookById(id);

        if (bookById.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build(); // return status code 404
        }

        return ResponseEntity.ok(bookById.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDto> deleteBookById(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<BookDto> create(@RequestBody BookDto bookDto, UriComponentsBuilder uriComponentsBuilder) {
        long bookId = bookService.createBook(bookDto);

        // http//:localhost::8080/books/id
        URI location = uriComponentsBuilder
                .path("/books/{id}")
                .buildAndExpand(bookId)
                .toUri();

        return ResponseEntity.created(location).build();
    }
}

