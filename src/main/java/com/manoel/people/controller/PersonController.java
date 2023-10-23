package com.manoel.people.controller;

import com.manoel.people.dto.request.PersonRequestDTO;
import com.manoel.people.dto.response.PersonResponseDTO;
import com.manoel.people.service.impl.PersonServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<PersonResponseDTO> findPersonById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(personService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> register(@RequestBody @Valid PersonRequestDTO personRequestDTO) {
        var personResponseDTO = personService.register(personRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(personResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(personResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO> update(@PathVariable UUID id, @RequestBody @Valid PersonRequestDTO personRequestDTO) {
        var personResponseDTO = personService.update(id, personRequestDTO);
        return ResponseEntity.ok().body(personResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
