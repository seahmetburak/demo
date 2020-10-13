package com.example.demo.Service;

import com.example.demo.Dao.PersonDao;
import com.example.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public void addperson(Person person){
        personDao.addPerson(person);
    }

    public Optional<Person> getPersonById(UUID uuid){
        return personDao.selectPersonById(uuid);
    }

    public List<Person> gellAllPerson(){
        return personDao.gettallPersons();
    }

    public void deletePersonById(UUID id){
         personDao.deletePersonByNumber(id);
    }

    public void updatePersonById(UUID id,Person person){
         personDao.updatePersonByNumber(id,person);
    }

}
