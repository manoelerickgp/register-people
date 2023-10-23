package com.manoel.people.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonRequestDTO {

    private String name;
    private String cpf;
    private Integer age;
}
