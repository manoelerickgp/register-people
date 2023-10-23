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
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonResponseDTO findById(UUID id) {
        return new PersonResponseDTO(returnPerson(id));
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        List<Person> listPerson = repository.findAll();
        return listPerson.stream().map(PersonResponseDTO::new).toList();
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {
        Person person = PersonMapper.toPerson(personDTO);
        return new PersonResponseDTO(repository.save(person));
    }

    @Override
    public PersonResponseDTO update(UUID id, PersonRequestDTO personDTO) {
        Person personSaved = returnPerson(id);
        updatePersonData(personSaved, personDTO);
        return new PersonResponseDTO(repository.save(personSaved));
    }

    @Override
    public void delete(UUID id) {
        repository.delete(returnPerson(id));
    }

    private Person returnPerson(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person Not Found"));
    }

    private void updatePersonData(Person personSaved, PersonRequestDTO personRequestDTO) {
        personSaved.setName(personRequestDTO.getName());
        personSaved.setCpf(personRequestDTO.getCpf());
        personSaved.setAge(personRequestDTO.getAge());
    }
}
