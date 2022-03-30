package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.domain.Position;
import softuni.exam.domain.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player findPlayerByNumber(Integer number);
}
