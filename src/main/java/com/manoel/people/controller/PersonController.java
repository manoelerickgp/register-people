package com.manoel.people.controller;

import com.manoel.people.dto.response.PersonResponseDTO;
import com.manoel.people.service.PersonServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO> findPersonById(@PathVariable Long id) {
        return ResponseEntity.ok().body(personService.findById(id));
    }
}
