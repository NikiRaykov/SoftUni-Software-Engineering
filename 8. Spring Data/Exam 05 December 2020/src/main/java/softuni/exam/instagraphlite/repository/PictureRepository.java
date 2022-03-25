package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.Picture;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
    Picture findByPath(String path);

    List<Picture> findAllBySizeGreaterThanOrderBySize(double size);
}
