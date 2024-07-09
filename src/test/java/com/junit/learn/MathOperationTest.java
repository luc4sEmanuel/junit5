package com.junit.learn;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.Random.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayName("MathOperationTest unit test")
class MathOperationTest {

    private static final MathOperation mathOperationTest = new MathOperation();

    @Test
    @DisplayName("Test sum operation")
     void should_test_sum_operation() {
        //given
        final double firstNumber = 1;
        final double secondNumber = 2;
        final double expectedResult = 3;

        //when
        final var resultSumOperation = mathOperationTest.sum(firstNumber,secondNumber);

        //then
        Assertions.assertEquals(expectedResult, resultSumOperation);
    }

    @DisplayName("Test subtract operation with @ParameterizedTest")
    @ParameterizedTest
    @MethodSource("should_test_subtract_operation")
    void should_test_subtract_operation(final double firstNumber, final double secondNumber, final double expected) {
        final var expectedValue = mathOperationTest.subtract(firstNumber, secondNumber);
        Assertions.assertEquals(expectedValue, expected);
    }

    @DisplayName("Test multiply operation @firstNumber")
    @ParameterizedTest
    @MethodSource
    void should_test_multiply_operation_successfully(final double firstNumber, final double secondNumber, final double expectedNumber){
        final var expectedValue = mathOperationTest.multiply(firstNumber, secondNumber);
        Assertions.assertEquals(expectedValue, expectedNumber);
    }

    @DisplayName("Test division operation: [firstNumber, secondNumber, expectedNumber]")
    @ParameterizedTest
    @MethodSource
    void should_test_division_successfully(final double firstNumber, final double secondNumber, final double expectedNumber){
        Assertions.assertEquals(mathOperationTest.divide(firstNumber, secondNumber), expectedNumber, 2D);
    }

    @DisplayName("Test division operation by zero")
    @ParameterizedTest
    @ValueSource(doubles = 0)
    void should_test_division_successfully(final double divideBy){
        final double originalValue = 100;
        Assertions.assertThrows(ArithmeticException.class, () -> mathOperationTest.divide(originalValue, divideBy));
    }

    @DisplayName("Test division operation by zero using csvSource parameter")
    @ParameterizedTest
    @CsvSource({"100, 0"})
    void should_test_division_successfully(final double originalValue, final double divideBy) {
        Assertions.assertThrows(ArithmeticException.class, () -> mathOperationTest.divide(originalValue, divideBy));
    }

   static Stream<Arguments> should_test_subtract_operation(){
        return Stream.of(
          Arguments.of(10,9,1),
          Arguments.of(966,900,66)
        );
    }

   static Stream<Arguments> should_test_multiply_operation_successfully(){
       return Stream.of(
               Arguments.of(10,9,90),
               Arguments.of(966,900,869400)
       );
    }

   static  Stream<Arguments> should_test_division_successfully(){
       return Stream.of(
               Arguments.of(10,9,0.D),
               Arguments.of(966,900,1,07D)
       );
   }
}
