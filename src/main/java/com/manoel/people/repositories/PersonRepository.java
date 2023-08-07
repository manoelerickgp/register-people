package com.manoel.people.repositories;

import com.manoel.people.entities.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PersonRepository {

    private Map<Long, Person> map = new HashMap<>();

    public Person save(Person obj) {
        return map.put(obj.getId(), obj);
    }

    public Person findById(Long id) {
        return map.get(id);
    }

    public List<Person> findAll() {
        return new ArrayList<Person>(map.values());
    }


}
