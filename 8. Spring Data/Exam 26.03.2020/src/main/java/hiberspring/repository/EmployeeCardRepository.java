package hiberspring.repository;

import hiberspring.domain.entity.Branch;
import hiberspring.domain.entity.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard, Integer> {
    EmployeeCard findEmployeeCardByNumber(String number);
}
