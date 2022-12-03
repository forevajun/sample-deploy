package ru.forevajun.sample.back.db.dao;

import ru.forevajun.sample.back.db.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonDao extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);

}
