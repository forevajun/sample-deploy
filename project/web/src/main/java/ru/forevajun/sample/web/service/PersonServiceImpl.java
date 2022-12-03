package ru.forevajun.sample.web.service;

import ru.forevajun.sample.web.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service("personServiceImpl")
@Profile("!dev")
public class PersonServiceImpl implements PersonService {

    private RestTemplate restTemplate;

    @Autowired
    public PersonServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.back.url}")
    private String url;

    @Override
    public void addPerson(PersonDto personDto) {
        restTemplate.postForEntity(url + "/create", personDto, PersonDto.class);
    }

    @Override
    public List<PersonDto> getPersonList() {
        ResponseEntity<PersonDto[]> response = restTemplate.getForEntity(url + "/list", PersonDto[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

}
