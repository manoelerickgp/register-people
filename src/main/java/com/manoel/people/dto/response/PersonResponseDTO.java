package com.manoel.people.dto.response;

import com.manoel.people.entities.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@Data
public class PersonResponseDTO implements Serializable {

    private UUID id;
    private String name;
    private String cpf;
    private Integer age;


    public PersonResponseDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.cpf = person.getCpf();
        this.age = person.getAge();
    }
}
