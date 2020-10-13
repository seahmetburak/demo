package com.example.demo.Dao;

import com.example.demo.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("fakeDao")
public class FakePersonDataAcces implements PersonDao {
    private static List<Person> DB=new ArrayList<>();

    @Override
    public void inserPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
    }

    @Override
    public List<Person> gettallPersons() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findAny();
    }
    @Override
    public void deletePersonByNumber(UUID id) {
       var maybePerson=selectPersonById(id);
       if(!maybePerson.isEmpty())
           DB.removeIf(person -> person.getId().equals(id));

    }
    @Override
    public void updatePersonByNumber(UUID id, Person update) {
       var arrayToFindIndex=DB.stream().filter(person -> person.getId().equals(id)).
               map(person -> {
                   int index=DB.indexOf(person);
                   return index;
               }).toArray();
       var index=(int)arrayToFindIndex[0];
       DB.set(index,new Person(id,update.getName()));

    }

}
