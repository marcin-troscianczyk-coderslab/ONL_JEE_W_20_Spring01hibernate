package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookDao bookDao;

    public void save(Book book) {
        bookDao.save(book);
    }

    public Book findById(Long id) {
        return bookDao.findById(id);
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public List<Book> findByRating(int rating) {
        return bookDao.findByRating(rating);
    }

    public List<Book> findByPublisherIsNotNull() {
        return bookDao.findByPublisherIsNotNull();
    }

    public List<Book> findByPublisher(Publisher publisher) {
        return bookDao.findByPublisher(publisher);
    }

    public List<Book> findByAuthor(Author author) {
        return bookDao.findByAuthor(author);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void deleteById(Long id) {
        bookDao.deleteById(id);
    }
}
