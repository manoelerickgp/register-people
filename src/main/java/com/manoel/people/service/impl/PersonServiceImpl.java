package com.manoel.people.service.impl;

import com.manoel.people.dto.request.PersonRequestDTO;
import com.manoel.people.dto.response.PersonResponseDTO;
import com.manoel.people.entities.Person;
import com.manoel.people.exceptions.ResourceNotFoundException;
import com.manoel.people.mapper.PersonMapper;
import com.manoel.people.repositories.PersonRepository;
import com.manoel.people.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonResponseDTO findById(Long id) {
        return PersonMapper.toPersonDTO(returnPerson(id));
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        return PersonMapper.toPersonDtoList(repository.findAll());
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {
        Person person = PersonMapper.toPerson(personDTO);
        return PersonMapper.toPersonDTO(repository.save(person));
    }

    @Override
    public PersonResponseDTO update(Long id, PersonRequestDTO personDTO) {
        Person person = returnPerson(id);
        PersonMapper.updatePersonData(person, personDTO);
        return PersonMapper.toPersonDTO(repository.save(person));
    }

    @Override
    public void delete(Long id) {
        repository.delete(returnPerson(id));
    }

    private Person returnPerson(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person Not Found"));
    }
}
