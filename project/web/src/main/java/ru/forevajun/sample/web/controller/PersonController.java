package ru.forevajun.sample.web.controller;

import ru.forevajun.sample.web.dto.PersonDto;
import ru.forevajun.sample.web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@Controller
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/add")
    public String add(@RequestParam(required = false) String name,
                      @RequestParam(required = false) String surname,
                      @RequestParam(required = false) String phoneNumber) {
        if (isNotEmpty(name) || isNotEmpty(surname) || isNotEmpty(phoneNumber)) {
            personService.addPerson(new PersonDto(name, surname, phoneNumber));
        }
        return "add";
    }

    @GetMapping("/list")
    public String people(Model model) {
        model.addAttribute("persons", personService.getPersonList());
        return "list";
    }

}