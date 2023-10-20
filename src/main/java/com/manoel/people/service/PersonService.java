package com.manoel.people.service;

import com.manoel.people.dto.request.PersonRequestDTO;
import com.manoel.people.dto.response.PersonResponseDTO;
import com.manoel.people.entities.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {

    PersonResponseDTO findById(UUID id);
    List<PersonResponseDTO> findAll();
    PersonResponseDTO register(PersonRequestDTO personDTO);
    PersonResponseDTO update(UUID id, PersonRequestDTO personDTO);
    void delete(UUID id);

}
