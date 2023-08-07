package com.manoel.people.resources;

import com.manoel.people.entities.Person;
import com.manoel.people.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/persons")
public class PersonResource {

    private PersonService service;

    public PersonResource(PersonService service){
        this.service = service;
    }

    @GetMapping
    public List<Person> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
