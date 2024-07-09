package com.junit.learn;

import com.junit.learn.models.Person;
import com.junit.learn.service.PersonService;
import com.junit.learn.service.PersonServiceImpl;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

@DisplayName("PersonServiceTest test person service operations")
class PersonServiceTest {

    private static final PersonService personService = new PersonServiceImpl();

    private Person person;

    @BeforeEach
    public void setUpEach(){
            person = new Person(String.valueOf(UUID.randomUUID()), "Lucas", "Emanuel", "Male","lucas.santana@email.com",33);
    }

    @DisplayName("Should validate the person object creation successfully and all fields match")
    @Test
    void shouldValidatePersonCreationSuccessfully(){
        final var personPersisted = personService.insert(person);
        assertThat(person).usingRecursiveComparison().isEqualTo(personPersisted);
    }


    @DisplayName("Should validate the person object creation successfully and all fields not match")
    @Test
    void shouldValidatePersonCreationFail(){
        personService.insert(person);
        assertThat(person).usingRecursiveComparison().isNotEqualTo(new Person(String.valueOf(UUID.randomUUID()), "Lucas", "Emanuel", "Male","lucas.santana@email.com",33));
    }
}
