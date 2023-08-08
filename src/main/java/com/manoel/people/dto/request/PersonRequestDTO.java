package com.manoel.people.dto.request;

import com.manoel.people.entities.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PersonRequestDTO {

    private String name;
    private String cpf;
    private Integer age;

    public PersonRequestDTO(Person person) {
        this.name = person.getName();
        this.cpf = person.getCpf();
        this.age = person.getAge();
    }


}
