package ru.forevajun.sample.back.service.converter;

import ru.forevajun.sample.back.db.entity.Person;
import ru.forevajun.sample.back.dto.PersonDto;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;
import static org.dozer.loader.api.TypeMappingOptions.wildcard;

@Component
public class Dto_To_Entity_Converter extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(PersonDto.class, Person.class, oneWay(), wildcard(false))
                .fields("id", "id")
                .fields("name", "name")
                .fields("surname", "surname")
                .fields("phoneNumber", "phoneNumber")
        ;
    }

}
