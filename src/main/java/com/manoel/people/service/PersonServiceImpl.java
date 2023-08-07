package com.manoel.people.service;

import com.manoel.people.entities.Person;
import com.manoel.people.repositories.PersonRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class PersonServiceImpl implements PersonService {

    private PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository){
        this.repository = repository;
    }

    @Override
    public Person findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public Person save(Person obj) {
        return repository.save(obj);
    }
}
