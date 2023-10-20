package com.manoel.people.mapper;

import com.manoel.people.dto.request.PersonRequestDTO;
import com.manoel.people.dto.response.PersonResponseDTO;
import com.manoel.people.entities.Person;

import java.util.List;

public class PersonMapper {

    public static Person toPerson(PersonRequestDTO personDTO) {
        return Person.builder()
                .name(personDTO.getName())
                .cpf(personDTO.getCpf())
                .age(personDTO.getAge())
                .build();
    }

    public static PersonResponseDTO toPersonDTO(Person person) {
        return new PersonResponseDTO(person);
    }

    public static List<PersonResponseDTO> toPersonDtoList(List<Person> personList) {
        return personList.stream().map(PersonResponseDTO::new).toList();
    }

    public static void updatePersonData(Person person, PersonRequestDTO personRequestDTO) {
        person.setName(personRequestDTO.getName());
        person.setCpf(personRequestDTO.getCpf());
        person.setAge(personRequestDTO.getAge());
    }
}
