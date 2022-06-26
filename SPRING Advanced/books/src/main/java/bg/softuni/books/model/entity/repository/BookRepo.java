package bg.softuni.books.model.entity.repository;

import bg.softuni.books.model.entity.BookEntity;
import bg.softuni.books.model.entity.dto.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long> {
}
