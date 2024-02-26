package com.skypro.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
class CalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();

    @Test
    void sum() {
        assertEquals(3,calculatorService.sum(1,2));
    }

    @Test
    void difference() {assertEquals(2,calculatorService.difference(3,1));

    }

    @Test
    void multiplication() {assertEquals(4,calculatorService.multiplication(2,2));
    }

    @Test
    void division() {assertEquals(2,calculatorService.division(4,2));

        assertThrows(IllegalAccessException.class, () -> calculatorService.division(1,0));
    }
}