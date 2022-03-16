package softuni.exam.models.entities;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
