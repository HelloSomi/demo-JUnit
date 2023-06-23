package com.example.demoJUnit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTests {

    Calculator calc = new Calculator();


    @Test
    public void testAddNumber() {

        assertEquals(10, calc.add(5, 5));
    }

    @Test
    public void testAdd() {

        assertEquals(20, calc.add(10, 10));
    }


    @Test
    public void testSubtract() {


        assertEquals(0, calc.subtract(5, 5));
    }

    @Test
    public void testMultiplyTwoNumbers() {


        assertEquals(25, calc.multiply(5, 5));
    }

    @Test
    public void testDivideTwoNumbers() {


        assertEquals(5, calc.divide(25, 5));
    }


    //vill vi checka så att uträkningen stämmer överens med resultatet


    @Test
    public void testSquareRootOfPositiveInteger() {
        double result = calc.squareRootOf(9);
        assertEquals(3.0, result);
    }


    // Här kollar vi att vår test faktiskt skickar tillbaka NaN när vi försöker få roten ur ett negativt tal
    @Test
    public void testSquareRootOfZero() {
        double result = calc.squareRootOf(0);
        assertEquals(0.0, result);
    }

    @Test
    public void testSquareRootOfNegativeNumber() {
        double result = calc.squareRootOf(-9);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testSquareRootOfDecimalNumber() {
        double result = calc.squareRootOf(2.25);
        assertEquals(1.5, result);
    }


    //vill vi checka så att svaret stämmer överens med resultatet
    @Test

    public void testGetArea() {

        assertEquals(50.27, calc.getArea(4));

    }

    // test för en kvadrat med sidläng 5
    @Test
    public void testSquareWithSideLengthFive() {
        double a = 5.0;
        double expectedArea = 78.54;

        assertEquals(expectedArea, calc.getArea(a));
    }




    //vill vi checka så att uträkningen stämmer överens med resultatet
    @Test
    public void testGetAreaWithPositiveInput() {
        double result = calc.getArea(5);

        assertEquals(78.54, result);

    }

    @Test
// Här kollar vi att vår test faktiskt skickar tillbaka NaN "not a number" när vi försöker få arean av ett negativt tal
    public void testGetAreaWithNegativeInput() {
        double result = calc.getArea(-1);

        assertTrue(Double.isNaN(result));

    }

    @Test
//vill vi checka så att uträkningen stämmer överens med resultatet
    public void testGetCircumferenceWithValidInput() {
        double result = calc.getCircumference(12);

        assertEquals(75.4, result);

    }

    @Test
// Här kollar vi att vår test faktiskt skickar tillbaka NaN när vi försöker få arean av ett negativt tal
    public void testGetCircumferenceWithInvalidInput() {
        double result = calc.getCircumference(-10);

        assertTrue(Double.isNaN(result));

    }
}
