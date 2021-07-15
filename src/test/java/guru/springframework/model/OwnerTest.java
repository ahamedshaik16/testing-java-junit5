package guru.springframework.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(11l, "Sohail", "Ahamed");
        owner.setCity("Hyderabad");
        owner.setTelephone("9876543210");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Sohail", owner.getFirstName()),
                        () -> assertEquals("Ahamed", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Hyderabad", owner.getCity()),
                        () -> assertEquals("9876543210", owner.getTelephone())));

        assertThat(owner.getCity(), is("Hyderabad"));
    }

}