package com.manoel.people.dto.request;

import lombok.Data;

@Data
public class PersonRequestDTO {

    private String name;
    private String cpf;
    private Integer age;
}
