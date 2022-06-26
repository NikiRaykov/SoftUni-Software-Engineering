package bg.softuni.books.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class BookEntity extends BaseEntity {

    public BookEntity(){}

    private String title;
    private String isbn;

    @ManyToOne(cascade = CascadeType.ALL)
    private AuthorEntity author;

    public String getTitle() {
        return title;
    }

    public BookEntity setTitle(String title) {
        this.title = title;
        return null;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookEntity setIsbn(String isbn) {
        this.isbn = isbn;
        return null;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public BookEntity setAuthor(AuthorEntity author) {
        this.author = author;
        return null;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author=" + author +
                '}';
    }
}
