package guru.springframework.model;

import guru.springframework.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        Person person = new Person(11l, "Sohail", "Ahamed");

        assertAll("Test Properties",
                () -> assertEquals("Sohail", person.getFirstName()),
                () -> assertEquals("Ahamed", person.getLastName()));
    }

    @Test
    void groupedAssertionMsgs() {
        Person person = new Person(11l, "Sohail", "Ahamed");

        assertAll("Test Properties",
                () -> assertEquals("Sohail", person.getFirstName(),  "First Name failed"),
                () -> assertEquals("Ahamed", person.getLastName(),  "Last Name failed"));
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    @Test
    void myRepeatedTests() {
        //todo
    }
}