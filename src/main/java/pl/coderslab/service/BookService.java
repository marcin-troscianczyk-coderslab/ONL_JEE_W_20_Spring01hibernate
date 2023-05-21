package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookDao bookDao;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    public void save(Book book) {

        Publisher publisher = book.getPublisher();
        publisherService.save(publisher);

        List<Author> authors = book.getAuthors();

        List<Author> filteredAuthors =
                authors.stream()
                        .filter(a -> authorService.findById(a.getId()) != null)
                        .collect(Collectors.toList());
        book.setAuthors(filteredAuthors);

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

    public void update(Book book) {
        bookDao.update(book);
    }

    public void deleteById(Long id) {
        bookDao.deleteById(id);
    }
}
