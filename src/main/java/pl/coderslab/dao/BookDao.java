package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findAll() {
        return //entityManager.createQuery("select b from Book b join fetch b.authors")
                entityManager.createQuery("select b from Book b")
                .getResultList();
    }

    public List<Book> findByRating(int rating) {
        return entityManager.createQuery("select b from Book b where b.rating = :rating")
                .setParameter("rating", rating)
                .getResultList();
    }
    public void update(Book book) {
        entityManager.merge(book);
    }

    public void deleteById(Long id) {
        Book book = findById(id);
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }
}
