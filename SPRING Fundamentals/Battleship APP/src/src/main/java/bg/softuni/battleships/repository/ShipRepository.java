package bg.softuni.battleships.repository;

import bg.softuni.battleships.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    List<Ship> findAllByUserUsername(String username);

    List<Ship> findAllByUserUsernameNot(String username);

    Ship findByName(String attacker);
}
