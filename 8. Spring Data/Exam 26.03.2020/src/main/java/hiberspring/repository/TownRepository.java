package hiberspring.repository;

import hiberspring.domain.entity.Branch;
import hiberspring.domain.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town, Integer> {
}
