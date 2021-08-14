package com.stackroute.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    private int personId;
    private String personName;
    private String userName;
    private String password;

    public Person() {
    }

    public Person(int personId,String personName, String userName, String password) {
        this.personId = personId;
        this.userName = userName;
        this.password = password;
        this.personName = personName;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(int personId){
        this.personId = personId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
