package com.manoel.people.service;

import com.manoel.people.dto.request.PersonRequestDTO;
import com.manoel.people.dto.response.PersonResponseDTO;
import com.manoel.people.entities.Person;

import java.util.List;

public interface PersonService {

    PersonResponseDTO findById(Long id);
    List<PersonResponseDTO> findAll();
    PersonResponseDTO register(PersonRequestDTO personDTO);
    PersonResponseDTO update(Long id, PersonRequestDTO personDTO);
    void delete(Long id);

}
