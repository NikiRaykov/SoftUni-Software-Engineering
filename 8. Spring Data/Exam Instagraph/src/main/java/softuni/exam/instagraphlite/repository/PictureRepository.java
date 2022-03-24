package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.Picture;

import java.util.*;
import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
    Optional<Picture> findPictureByPath(String path);

    @Query("SELECT p FROM Picture p WHERE p.size > 30000 ORDER BY p.size")
    List<Picture> findPictureBySizeGreaterThanOrderBySize();
}
