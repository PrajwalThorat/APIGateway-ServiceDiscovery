package com.stackroute.controller;

import com.stackroute.exception.PersonAlreadyExistException;
import com.stackroute.exception.PersonNotFoundException;
import com.stackroute.model.Person;
import com.stackroute.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> addPersonData(@RequestBody Person person) throws PersonAlreadyExistException {
        return new ResponseEntity<>(personService.addPerson(person) , HttpStatus.CREATED);
    }

    @PutMapping("/{personId}")
    public ResponseEntity<Person> updatePersonData(@RequestBody Person person) throws PersonNotFoundException {
        return new ResponseEntity<>(personService.updatePerson(person) , HttpStatus.CREATED);
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<?> deletePersonData(@PathVariable int personId) throws PersonNotFoundException {
        return new ResponseEntity<>(personService.deletePerson(personId) , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersonData(){
        return new ResponseEntity<List<Person>>(personService.getListOfAllPerson() , HttpStatus.OK);
    }

}
