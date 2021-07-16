package guru.springframework.model;

import guru.springframework.ModelTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(11L, "Sohail", "Ahamed");
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

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    @ValueSource(strings = {"Sohail", "Ahamed", "Shaik"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }
}