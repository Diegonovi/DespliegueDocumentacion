package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Main test = new Main();

    @Test
    void idk() {
        // Arrange
        Boolean something = false;

        // Act
        String t = test.idk(something);

        // Assert
        assertEquals("i do know",t);
    }
}