package com.example.mycalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import javax.script.ScriptException;

public class EvaluateTest {

    //Test methods for multiplication and subtraction
    @Test
    public void evaluate_multiply() throws ScriptException{
        Evaluate eval = new Evaluate();
        double actual = eval.evaluate("3*4").doubleValue();
        double expected = 3*4;
        assertEquals("Error! The values don't match", expected, actual, 1e-4);
    }

    @Test
    public void evaluate_subtract() throws ScriptException{
        Evaluate eval = new Evaluate();
        double actual = eval.evaluate("10-10").doubleValue();
        double expected = 10-10;
        assertEquals("The values don't match", expected, actual, 1e-4);
    }

}