package ru.forevajun.sample.back.controller;

import ru.forevajun.sample.back.dto.PersonDto;
import ru.forevajun.sample.back.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonApiController {

    private PersonService personService;

    @Autowired
    public PersonApiController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<PersonDto> create(@RequestBody PersonDto personDto) {
        try {
            personDto = personService.create(personDto);
            return new ResponseEntity<>(personDto, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    @ResponseBody
    public PersonDto[] list() {
        return personService.list();
    }

}