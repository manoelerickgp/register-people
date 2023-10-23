package com.manoel.people.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonRequestDTO {

    @NotBlank(message = "name field cannot be empty")
    private String name;

    @NotBlank(message = "cpf field cannot be empty")
    private String cpf;

    @Min(value = 1, message = "field must contain at least one number")
    private Integer age;
}
