package com.dms.restful.core.domain.services;

import com.dms.restful.core.domain.model.Gender;
import com.dms.restful.core.domain.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

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
}
