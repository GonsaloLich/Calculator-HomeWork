package com.skypro.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.util.AssertionErrors;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParamCalculatorServiceTest {

   CalculatorService calculatorService = new CalculatorService();

   public static Stream<Arguments> args(){
       return Stream.of(
               Arguments.of(1, 2),
               Arguments.of(-1, 2),
               Arguments.of(1, -2),
               Arguments.of(-1, -2),
               Arguments.of(0, 2),
               Arguments.of(1, 0),
               Arguments.of(0, -2),
               Arguments.of(5, 5));
   }

   @ParameterizedTest
   @MethodSource("args")
    void nameSum(Integer num1, Integer num2) {
       assertEquals(num1+num2,calculatorService.sum(num1, num2));
   }
    @ParameterizedTest
    @MethodSource("args")
    void nameDifference(Integer num1, Integer num2) {
        assertEquals(num1 - num2,calculatorService.difference(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("args")
    void nameMultiplication(Integer num1, Integer num2) {
        assertEquals(num1 * num2,calculatorService.multiplication(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("args")
    void nameDivision(Integer num1, Integer num2) {
       if (num2 == 0){
           assertThrows(IllegalArgumentException.class, () -> calculatorService.division(num1, num2));
           return;
       }
       assertEquals(num1 / num2, calculatorService.division(num1, num2));
    }
}