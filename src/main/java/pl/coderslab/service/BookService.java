package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookDao bookDao;
    private final PublisherService publisherService;

    public void save(Book book) {

        Publisher publisher = book.getPublisher();
        publisherService.save(publisher);

        bookDao.save(book);
    }

    public Book findById(Long id) {
        return bookDao.findById(id);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void deleteById(Long id) {
        bookDao.deleteById(id);
    }
}
