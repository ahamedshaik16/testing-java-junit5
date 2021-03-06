package guru.springframework.controllers;

import guru.springframework.ControllerTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


class IndexControllerTest implements ControllerTests {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    @DisplayName("Test proper view name is returned for index")
    void index() {
        assertEquals("index", indexController.index());
        assertThat(indexController.index()).isEqualTo("index");
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

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {

    }

    @EnabledIfEnvironmentVariable(named =  "USER", matches = "sohail")
    @Test
    void testIfUserSohail() {

    }

}