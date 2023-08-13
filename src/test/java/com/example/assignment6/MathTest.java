package com.example.assignment6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MathTest {

    @Test
    void testMath() {
        Math math = new Math();
        Assertions.assertTrue(math.checkEven(2));
    }

    @Test
    void testMath2() {
        Math math = new Math();
        Assertions.assertFalse(math.checkEven(1));
    }
}