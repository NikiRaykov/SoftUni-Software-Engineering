package bg.softuni.books.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "authors")
public class AuthorEntity extends BaseEntity {

    public AuthorEntity(){}

    public AuthorEntity(String name, List<BookEntity> books) {
        this.name = name;
        this.books = books;
    }

    private String name;

    @OneToMany(mappedBy = "author")
    private List<BookEntity> books = new ArrayList<>();

    public String getName() {
        return name;

    }

    public AuthorEntity setName(String name) {
        this.name = name;
        return null;
    }

    public List<BookEntity> getBook() {
        return books;
    }

    public void setBook(List<BookEntity> books) {
        this.books = books;
    }

    public AuthorEntity addBook(BookEntity bookEntity) {
        this.books.add(bookEntity);
        return this;
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
