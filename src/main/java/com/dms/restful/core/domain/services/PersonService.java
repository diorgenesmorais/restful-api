package com.dms.restful.core.domain.services;

import com.dms.restful.core.domain.model.Gender;
import com.dms.restful.core.domain.model.Person;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());
    private final Faker faker = new Faker();
    private final List<Person> persons = new ArrayList<>();

    public Optional<Person> findById(Long id) {
        var info = String.format("Finding person by id %d", id);
        logger.info(info);
        Person found = findAll().stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(found);
    }
    
    public List<Person> findAll() {
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(null);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(Long id) {
        Person person = new Person();
        person.setId(id == null ? counter.incrementAndGet() : id);
        person.setFirstname(faker.name().firstName());
        person.setLastname(faker.name().lastName());
        person.setAdrress(faker.address().fullAddress());
        person.setGender(faker.bool().bool() ? Gender.MALE : Gender.FEMALE);
        return person;
    }
}
