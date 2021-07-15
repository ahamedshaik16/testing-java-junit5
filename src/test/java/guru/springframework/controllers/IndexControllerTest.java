package guru.springframework.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    @DisplayName("Test proper view name is returned for index")
    void index() {
        assertEquals("index", indexController.index());
    }

    @Test
    @DisplayName("Test Exception")
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            indexController.oopsHandler();
        });
    }

    @Disabled("Demo for TimeOut")
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("In TimeOut method");
        });
    }

    @Disabled("Demo for TimeOut")
    @Test
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("In TimeOutPreemptively...");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("SOHAIL".equalsIgnoreCase(System.getenv("SOHAIL_RUNTIME")));
    }

    @Test
    void testAssumptionTureAssumptionIsTrue() {
        assumeTrue("SOHAIL".equalsIgnoreCase("SOHAIL"));
    }
}