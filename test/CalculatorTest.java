package javatest;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.Before;

public class CalculatorTest {
    Calculator sut;
    /* Set up */
    @Before
    public void setUp() throws Exception {
        sut = new Calculator();
    }

    @Test
    public void getMultiplyResultOf3and4() {
        int expected = 12;
        // Exercise
        int actual = sut.multiply(3, 4);
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void getMultiplyResultOf5and7() {
        int expected = 35;
        // Exercise
        int actual = sut.multiply(5, 7);
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void getDivideResultOf3by2() {
        float expected = 1.5f;
        // Exercise
        float actual = sut.divide(3,2);
        // Verify
        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionIfDivide5by0() {
        // Exercise
        sut.divide(5, 0);
    }
}
