package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Person;

@Controller
class PersonController {

    @GetMapping(path = "/form")
    String showAddForm() {
        return "person/form";
    }

    @PostMapping(path = "/form")
    @ResponseBody
    String processAddForm(@RequestParam String login, @RequestParam String password, @RequestParam String email) {

        Person person = new Person();

        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);

        return person.toString();

    }
}
