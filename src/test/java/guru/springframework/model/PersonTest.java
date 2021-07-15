package guru.springframework.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

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

}