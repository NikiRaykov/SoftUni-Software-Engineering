package hiberspring.repository;


import hiberspring.domain.entity.Branch;
import hiberspring.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductByName(String name);
}
