package pl.coderslab.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByRating(int rating);
    List<Book> findByPublisherIsNotNull();
    @Query("select b from Book b where b.publisher = :publisher")
    List<Book> findByPublisher(@Param("publisher") Publisher publisher); // select b from Book b where b.publisher = :publisher
    List<Book> findByAuthorsContains(Author author);

    @Query("select b from Book b where b.title = :title")
    List<Book> findByTitle(@Param("title") String title);

    @Query("select b from Book b where b.category = :category")
    List<Book> findByCategory(@Param("category") Category category);

    List<Book> findByCategoryId(Long id);
    @Query("select b from Book b where b.category = :category")
    Page<Book> findFirstByCategoryOrderByTitle(@Param("category") Category category, Pageable pageable); // select b from Book b where b.category = :category order by b.title asc limit 1

    @Query("select b from Book b where b.rating between :min and :max")
    List<Book> findByRatingBetween(@Param("min") int min, @Param("max") int max);
}
