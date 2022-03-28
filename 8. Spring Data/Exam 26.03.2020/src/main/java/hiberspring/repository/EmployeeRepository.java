package hiberspring.repository;

import hiberspring.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT e FROM Employee e WHERE e.branch.products.size > 0 " +
            " ORDER BY concat(e.firstName, ' ', e.lastName), LENGTH(e.position) DESC")
    List<Employee> findAllByBranchWithMoreThanOneProduct();
}
