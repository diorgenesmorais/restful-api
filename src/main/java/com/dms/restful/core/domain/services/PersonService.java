package com.dms.restful.core.domain.services;

import com.dms.restful.core.domain.model.Gender;
import com.dms.restful.core.domain.model.Person;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());
    private final Faker faker = new Faker();

    public Person findById(Long id) {
        var info = String.format("Finding person by id %d", id);
        logger.info(info);
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstname("Diorgenes");
        person.setLastname("Morais");
        person.setAdrress("São Lourenço da Mata, PE");
        person.setGender(Gender.MALE);
        return person;
    }
    
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson();
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson() {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstname(faker.name().firstName());
        person.setLastname(faker.name().lastName());
        person.setAdrress(faker.address().fullAddress());
        person.setGender(faker.bool().bool() ? Gender.MALE : Gender.FEMALE);
        return person;
    }
}
