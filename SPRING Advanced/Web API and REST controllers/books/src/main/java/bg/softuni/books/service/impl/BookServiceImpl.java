package bg.softuni.books.service.impl;

import bg.softuni.books.model.entity.AuthorEntity;
import bg.softuni.books.model.entity.BookEntity;
import bg.softuni.books.model.entity.dto.AuthorDto;
import bg.softuni.books.model.entity.dto.BookDto;
import bg.softuni.books.model.entity.repository.AuthorRepo;
import bg.softuni.books.model.entity.repository.BookRepo;
import bg.softuni.books.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final ModelMapper modelMapper;
    private final AuthorRepo authorRepo;

    public BookServiceImpl(BookRepo bookRepo, ModelMapper modelMapper, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.modelMapper = modelMapper;
        this.authorRepo = authorRepo;
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepo.findAll().stream()
                .map(this::asBook)
                .collect(Collectors.toList());

    }

    @Override
    public Optional<BookDto> findBookById(Long id) {
        return bookRepo.findById(id)
                .map(this::asBook);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public long createBook(BookDto bookDto) {
        AuthorEntity author = authorRepo
                .findByName(bookDto.getAuthorDto().getName())
                .orElseGet(() -> new AuthorEntity().setName(bookDto.getAuthorDto().getName()));


        BookEntity book = new BookEntity()
                .setAuthor(author)
                .setIsbn(bookDto.getIsbn())
                .setTitle(bookDto.getTitle());


        return bookRepo.save(book).getId();
    }

    private BookDto asBook(BookEntity book) {
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        AuthorDto authorDto = modelMapper.map(book.getAuthor(), AuthorDto.class);

        bookDto.setAuthorDto(authorDto);

        return bookDto;
    }

}
