package ru.forevajun.sample.back.service;

import ru.forevajun.sample.back.db.dao.PersonDao;
import ru.forevajun.sample.back.db.entity.Person;
import ru.forevajun.sample.back.dto.PersonDto;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.StreamSupport;

@Service
public class PersonService {

    private PersonDao personDao;
    private DozerBeanMapper mapper;

    @Autowired
    public PersonService(PersonDao personDao, DozerBeanMapper mapper) {
        this.personDao = personDao;
        this.mapper = mapper;
    }

    public PersonDto create(PersonDto personDto) {
        Person person = mapper.map(personDto, Person.class);
        Person personSaved = personDao.save(person);
        return mapper.map(personSaved, PersonDto.class);
    }

    public PersonDto[] list() {
        Iterable<Person> personIterable = personDao.findAll();
        return StreamSupport.stream(personIterable.spliterator(), false)
                .map(it -> mapper.map(it, PersonDto.class))
                .sorted(Comparator.comparing(PersonDto::getId))
                .toArray(PersonDto[]::new);
    }

}
