package com.manoel.people;

import com.manoel.people.entities.Person;
import com.manoel.people.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PeopleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PeopleApplication.class, args);
	}

	@Autowired
	private PersonRepository repository;

	@Override
	public void run(String... args) throws Exception {


		Person p1 = new Person(null, "Alex White", "111111111-11", 37);
		Person p2 = new Person(null, "Maria Blue", "222222222-22", 26);
		Person p3 = new Person(null, "Bob Green", "333333333-33", 24);
		Person p4 = new Person(null, "Joao Brown", "444444444-44", 42);

		repository.saveAll(Arrays.asList(p1, p2, p3, p4));


	}
}
