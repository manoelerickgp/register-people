package com.manoel.people.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_people")
@NoArgsConstructor
@Getter
@Setter(AccessLevel.NONE)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    private String cpf;
    private Integer age;

    public Person(String name, String cpf, Integer age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }

    public Person(Long id, String name, String cpf, Integer age) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }
}
