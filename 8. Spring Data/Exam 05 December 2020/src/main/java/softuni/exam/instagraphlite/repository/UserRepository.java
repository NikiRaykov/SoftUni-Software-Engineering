package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.User;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Query("SELECT u FROM User u JOIN u.posts p ORDER BY size(u.posts) DESC, u.id")
    Set<User> findAllOrderBySizePostsDescAndId();
}
