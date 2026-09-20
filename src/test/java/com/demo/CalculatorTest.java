package com.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void addsTwoNumbers() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void subtractsTwoNumbers() {
        assertEquals(1, calc.subtract(3, 2));
    }

    @Test
    void multipliesTwoNumbers() {
        assertEquals(6, calc.multiply(2, 3));
    }

    @Test
    void dividesTwoNumbers() {
        assertEquals(5, calc.divide(10, 2));
    }

    @Test
    void refusesToDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(10, 0));
    }
}
