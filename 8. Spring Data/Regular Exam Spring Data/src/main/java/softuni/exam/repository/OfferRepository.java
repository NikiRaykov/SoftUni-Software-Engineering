package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Offer;

import java.util.*;
import java.math.BigDecimal;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
