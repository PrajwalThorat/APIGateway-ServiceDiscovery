package com.stackroute.service;

import com.stackroute.exception.PersonAlreadyExistException;
import com.stackroute.exception.PersonNotFoundException;
import com.stackroute.model.Person;

import java.util.List;

public interface PersonService {

    public Person addPerson(Person person) throws PersonAlreadyExistException;

    public Person updatePerson(Person person) throws PersonNotFoundException;

    public Person deletePerson(int personId) throws PersonNotFoundException;

    List<Person> getListOfAllPerson();

    public Person getPersonById(int personId) throws PersonNotFoundException;
}
