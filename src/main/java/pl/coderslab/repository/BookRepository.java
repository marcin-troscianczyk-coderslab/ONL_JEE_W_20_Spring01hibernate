package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByRating(int rating);
    List<Book> findByPublisherIsNotNull();
    List<Book> findByPublisher(Publisher publisher);
    List<Book> findByAuthorsContains(Author author);

    List<Book> findByTitle(String title);
    List<Book> findByCategory(Category category);
    List<Book> findByCategoryId(Long id);
    Optional<Book> findFirstByCategoryOrderByTitle(Category category);
}
