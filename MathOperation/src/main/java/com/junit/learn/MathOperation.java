package com.junit.learn;

public class MathOperation {

    public double sum(final double firstNumber, final double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double subtract(final double firstNumber, final double secondNumber) {
        return firstNumber - secondNumber;
    }

    public double multiply(final double firstNumber, final double secondNumber){
        return firstNumber * secondNumber;
    }

    public double divide(final double firstNumber, final double secondNumber) throws ArithmeticException {
        if(secondNumber == 0)
            throw new ArithmeticException("It's impossible divide a number by zero");
        return firstNumber / secondNumber;
    }

}
