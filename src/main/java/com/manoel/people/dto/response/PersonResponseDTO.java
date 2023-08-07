package com.manoel.people.dto.response;

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


    public PersonResponseDTO(Long id, String name, String cpf, Integer age) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }
}
