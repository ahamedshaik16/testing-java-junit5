package guru.springframework.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void oupsHandler() {
        assertTrue("notimplemented".equals(indexController.oupsHandler()), () -> "This is some test meesage" +
                "It is to build my test");
    }
}