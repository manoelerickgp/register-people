package com.manoel.people.service;

import com.manoel.people.dto.request.PersonRequestDTO;
import com.manoel.people.dto.response.PersonResponseDTO;
import com.manoel.people.entities.Person;
import com.manoel.people.exceptions.ResourceNotFoundException;
import com.manoel.people.mapper.PersonMapper;
import com.manoel.people.repositories.PersonRepository;
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
        Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person Not Found"));
        return PersonMapper.toPersonDTO(person);
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        List<Person> list = repository.findAll();
        return PersonMapper.toPersonDtoList(list);
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {
        Person person = PersonMapper.toPerson(personDTO);
        return PersonMapper.toPersonDTO(repository.save(person));
    }

    @Override
    public PersonResponseDTO update(Long id, PersonRequestDTO personDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }
}
