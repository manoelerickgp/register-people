package com.manoel.people.mapper;

import com.manoel.people.dto.request.PersonRequestDTO;
import com.manoel.people.dto.response.PersonResponseDTO;
import com.manoel.people.entities.Person;

import java.util.List;

public class PersonMapper {

    public Person toPerson(PersonRequestDTO personDTO) {
        return Person.builder()
                .name(personDTO.getName())
                .cpf(personDTO.getCpf())
                .age(personDTO.getAge())
                .build();
    }

    public PersonResponseDTO toPersonDTO(Person person) {
        return new PersonResponseDTO(person);
    }

    public List<PersonResponseDTO> toPersonDtoList(List<Person> personList) {
        return personList.stream().map(PersonResponseDTO::new).toList();
    }

}
