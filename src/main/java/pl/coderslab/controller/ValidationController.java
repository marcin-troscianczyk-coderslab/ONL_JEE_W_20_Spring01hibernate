package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequiredArgsConstructor
class ValidationController {

    private final Validator validator;

    @GetMapping("/validate")
    String validateTest(Book book, Model model) {

        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        model.addAttribute("violations", violations);

        return "validator/result";
    }
}
