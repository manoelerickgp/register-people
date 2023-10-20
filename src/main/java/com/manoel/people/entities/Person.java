package com.manoel.people.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_people")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID ")
    private UUID id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 15, nullable = false, unique = true)
    private String cpf;

    @Column(length = 3, nullable = false)
    private Integer age;

    @Builder
    public Person(String name, String cpf, Integer age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }

}
