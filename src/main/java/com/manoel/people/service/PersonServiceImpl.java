package com.manoel.people.service;

import com.manoel.people.entities.Person;
import com.manoel.people.repositories.PersonRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Primary
public class PersonServiceImpl implements PersonService {

    private PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository){
        this.repository = repository;
    }

    @Override
    public Person findById(Long id) {
        Optional<Person> obj = repository.findById(id);
        return obj.orElseThrow();
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
