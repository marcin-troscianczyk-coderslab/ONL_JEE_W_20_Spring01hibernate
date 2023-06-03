package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
class BookFormController {

    private final BookService bookService;
    private final PublisherService publisherService;

    // wyswietlenie formularza dodawania ksiazki
    @GetMapping(path = "/book/form")
    String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    // obsluga formularza dodawania ksiazki
    @PostMapping(path = "/book/form")
    String processAddBookForm(Book book) {

        bookService.save(book);

        return "redirect:/book/list";
    }

    // wyswietlanie listy wszystkich ksiazek
    @GetMapping(path = "/book/list")
    String showBookList(Model model) {

        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);

        return "book/list";
    }

    // umieszczenie w modelu pod kluczem 'publishers' kolekcji obiektow Publisher
    @ModelAttribute("publishers")
    Collection<Publisher> findAllPublishers() {
        System.out.println("Ala ma kota");
        return publisherService.findAll();
    }
}
