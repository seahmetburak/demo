package com.example.demo.Api;

import com.example.demo.Model.Person;
import com.example.demo.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @RequestBody Person person){
        personService.addperson(person);
    }

    @GetMapping
    public List<Person> getPersons(){
        return personService.gellAllPerson();
    }

    @GetMapping("/find")
    public Optional<Person> getPersonById(@RequestParam(value = "id") UUID ıd){
        return personService.getPersonById(ıd);
    }

    @DeleteMapping("/delete")
    public void deletePersonById(@RequestParam("id") UUID ıd){
         personService.deletePersonById(ıd);
    }


    @PutMapping("/update")
    public void updatePesonById(@RequestParam("id") UUID id,@RequestBody Person person){
        personService.updatePersonById(id,person);
    }





}
