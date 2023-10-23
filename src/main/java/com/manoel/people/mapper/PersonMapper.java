package com.manoel.people.mapper;

import com.manoel.people.dto.request.PersonRequestDTO;
import com.manoel.people.entities.Person;

public class PersonMapper {

    public static Person toPerson(PersonRequestDTO personDTO) {
        return Person.builder()
                .name(personDTO.getName())
                .cpf(personDTO.getCpf())
                .age(personDTO.getAge())
                .build();
    }

}
