package com.manoel.people.service;

import com.manoel.people.dto.request.PersonRequestDTO;
import com.manoel.people.dto.response.PersonResponseDTO;
import com.manoel.people.entities.Person;
import com.manoel.people.exceptions.ResourceNotFoundException;
import com.manoel.people.mapper.PersonMapper;
import com.manoel.people.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository repository;
    private PersonMapper personMapper;

    @Override
    public PersonResponseDTO findById(Long id) {
        Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person Not Found"));
        return new PersonResponseDTO(person);
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        return null;
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {
        return null;
    }

    @Override
    public PersonResponseDTO update(PersonRequestDTO personDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
