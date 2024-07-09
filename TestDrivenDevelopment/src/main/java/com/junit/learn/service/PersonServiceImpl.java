package com.junit.learn.service;

import com.junit.learn.models.Person;

public class PersonServiceImpl implements  PersonService{

    @Override
    public Person insert(Person person) {
        return person;
    }
}
