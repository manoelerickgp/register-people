package com.manoel.people.dto.response;

import com.manoel.people.entities.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PersonResponseDTO {

    private Long id;
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
