package com.manoel.people.service;

import com.manoel.people.entities.Person;

import java.util.List;

public interface PersonService {

    Person findById(Long id);
    List<Person> findAll();

    Person save(Person obj);

}
