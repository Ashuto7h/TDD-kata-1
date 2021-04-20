package com.ashyk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    public void testGetCalledCount() {
        StringCalculator sc = new StringCalculator();
        try {
            sc.Add("1,2,3,4\n5");
        } catch (Exception e) {

        }
        assertEquals(2, sc.getCalledCount());
    }
}
