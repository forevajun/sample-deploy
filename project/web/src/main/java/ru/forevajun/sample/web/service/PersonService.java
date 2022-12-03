package ru.forevajun.sample.web.service;

import ru.forevajun.sample.web.dto.PersonDto;

import java.util.List;

public interface PersonService {

    void addPerson(PersonDto personDto);

    List<PersonDto> getPersonList();

}
