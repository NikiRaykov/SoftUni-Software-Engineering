package bg.softuni.books.model.entity.repository;

import bg.softuni.books.model.entity.AuthorEntity;
import bg.softuni.books.model.entity.dto.AuthorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> findByName(String name);
}
