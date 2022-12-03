package ru.forevajun.sample.web.service;

import ru.forevajun.sample.web.dto.PersonDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("personServiceStub")
@Profile("dev")
public class PersonServiceStub implements PersonService {

    private static final Map<String, PersonDto> personDtoMap = new HashMap<>();
    private static long id = 0L;

    @Override
    public void addPerson(PersonDto personDto) {
        personDto.setId(id);
        personDtoMap.put(String.valueOf(id++), personDto);
    }

    @Override
    public List<PersonDto> getPersonList() {
        return new ArrayList<>(personDtoMap.values());
    }

}
