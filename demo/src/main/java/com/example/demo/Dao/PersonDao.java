package com.example.demo.Dao;

import com.example.demo.Model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    void inserPerson(UUID id, Person person);
    List<Person> gettallPersons();
    Optional<Person> selectPersonById(UUID id);
    void deletePersonByNumber(UUID id);
    void updatePersonByNumber(UUID id,Person person);
    default void addPerson(Person person){
        UUID id=UUID.randomUUID();
        inserPerson(id,person);
    }
}
