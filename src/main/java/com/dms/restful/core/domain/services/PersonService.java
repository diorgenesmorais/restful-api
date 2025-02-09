package com.dms.restful.core.domain.services;

import com.dms.restful.core.domain.exceptions.BusinessException;
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

    public Person save(Person person) {
        logger.info("Creating one person");
        if (person.getId() == null) {
            person.setId(counter.incrementAndGet());
            persons.add(person);
        } else {
            persons.stream()
                    .filter(p -> p.equals(person))
                    .findFirst()
                    .ifPresent(
                            existingPerson -> {
                                existingPerson.setFirstname(person.getFirstname());
                                existingPerson.setLastname(person.getLastname());
                                existingPerson.setAdrress(person.getAdrress());
                                existingPerson.setGender(person.getGender());
                            }
                    );
        }
        return person;
    }

    public void update(Long id, Person person) {
        Person found = persons.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessException("Person não encontrado"));

        var info = String.format("Updating person %s to %s", found.getFirstname(), person.getFirstname());
        logger.info(info);
        person.setId(id);
        this.save(person);
    }
}
