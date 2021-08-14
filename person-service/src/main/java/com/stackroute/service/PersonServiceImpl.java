package com.stackroute.service;

import com.stackroute.exception.PersonAlreadyExistException;
import com.stackroute.exception.PersonNotFoundException;
import com.stackroute.model.Person;
import com.stackroute.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    private PersonRepo personRepo;

    @Autowired
    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public Person addPerson(Person person) throws PersonAlreadyExistException {
        if (personRepo.findById(person.getPersonId()).isPresent()){
            throw new PersonAlreadyExistException();
        }
        return personRepo.save(person);
    }

    @Override
    public Person updatePerson(Person person) throws PersonNotFoundException {
        if (!personRepo.findById(person.getPersonId()).isPresent()){
            throw new PersonNotFoundException();
        }
        return personRepo.save(person);
    }

    @Override
    public Person deletePerson(int personId) throws PersonNotFoundException {
        Person person = null;
        Optional optional = personRepo.findById(personId);
        if (!optional.isPresent()){
            throw new PersonNotFoundException();
        }else {
            person = personRepo.findById(personId).get();
            personRepo.deleteById(personId);
        }
        return person;
    }

    @Override
    public List<Person> getListOfAllPerson() {
        return personRepo.findAll();
    }

    @Override
    public Person getPersonById(int personId) throws PersonNotFoundException {
        Person person = null;
        Optional optional = personRepo.findById(personId);
        if (!optional.isPresent()){
            throw new PersonNotFoundException();
        }else {
            Person getPerson = personRepo.findById(personId).get();
            getPerson.setPersonId(person.getPersonId());
            getPerson.setPersonName(person.getPersonName());
            getPerson.setUserName(person.getUserName());
            person = personRepo.save(getPerson);
        }
        return person;
    }
}
