package com.manoel.people.dto.response;

import com.manoel.people.entities.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class PersonResponseDTO implements Serializable {

    private String name;
    private String cpf;
    private Integer age;


    public PersonResponseDTO(Person person) {
        this.name = person.getName();
        this.cpf = person.getCpf();
        this.age = person.getAge();
    }
}
