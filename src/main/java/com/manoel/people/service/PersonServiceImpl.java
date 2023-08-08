package com.manoel.people.service;

import com.manoel.people.dto.request.PersonRequestDTO;
import com.manoel.people.dto.response.PersonResponseDTO;
import com.manoel.people.entities.Person;
import com.manoel.people.repositories.PersonRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Primary
public class PersonServiceImpl implements PersonService {

    private PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository){
        this.repository = repository;
    }

    @Override
    public PersonResponseDTO findById(Long id) {
        Optional<Person> person = repository.findById(id);
        PersonResponseDTO obj = new PersonResponseDTO(person);
        return obj.orElseThrow(() -> new RuntimeException("Person not found on database"));
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public PersonResponseDTO save(PersonRequestDTO obj) {
        return repository.save(obj);
    }
}
