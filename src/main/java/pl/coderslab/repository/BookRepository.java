package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByRating(int rating);
    List<Book> findByPublisherIsNotNull();
    List<Book> findByPublisher(Publisher publisher); // select b from Book b where b.publisher = :publisher
    List<Book> findByAuthorsContains(Author author);

    @Query("select b from Book b where b.title = :title")
    List<Book> findByTitle(@Param("title") String title);

    @Query("select b from Book b where b.category = :category")
    List<Book> findByCategory(@Param("category") Category category);

    List<Book> findByCategoryId(Long id);
    Optional<Book> findFirstByCategoryOrderByTitle(Category category); // select b from Book b where b.category = :category order by b.title asc limit 1
}
