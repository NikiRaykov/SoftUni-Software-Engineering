package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.domain.entities.Player;

import java.math.BigDecimal;
import java.util.*;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByFirstNameAndLastName(String fname, String lname);
    // @Query("SELECT p FROM Player AS p WHERE p.team.name = :name")
    List<Player> findByTeamNameOrderById(String name);

    List<Player> findAllBySalaryGreaterThan(BigDecimal salary);
 }
