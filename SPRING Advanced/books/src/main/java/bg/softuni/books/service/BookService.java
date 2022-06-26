package bg.softuni.books.service;

import bg.softuni.books.model.entity.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDto> getAllBooks();

    Optional<BookDto> findBookById(Long id);

    void deleteBookById(Long id);

    long createBook(BookDto bookDto);

}
