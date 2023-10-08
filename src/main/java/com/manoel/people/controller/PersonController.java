package com.manoel.people.controller;

import com.manoel.people.dto.request.PersonRequestDTO;
import com.manoel.people.dto.response.PersonResponseDTO;
import com.manoel.people.service.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/people")
public class PersonController {

    private final PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<PersonResponseDTO>> findAllPersons(){
        return ResponseEntity.ok().body(personService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO> findPersonById(@PathVariable Long id) {
        return ResponseEntity.ok().body(personService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> register(@RequestBody PersonRequestDTO personReqDTO) {
        PersonResponseDTO personResponseDTO = personService.register(personReqDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(personResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(personResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO> update(@PathVariable Long id, @RequestBody PersonRequestDTO personReqDTO) {
        return ResponseEntity.ok().body(personService.update(id, personReqDTO));
    }


}
