package com.manoel.people.dto.request;

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

    public PersonRequestDTO(String name, String cpf, Integer age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }


}
