package javatest;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.DataPoints;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;

@RunWith(Theories.class)
public class CalcTheoriesTest {
    @DataPoints
    public static int [][] VALUES = {
        {0, 0, 0},
        {0, 1, 1},
        {1, 0, 1},
        {3, 4, 7},
    };

    @Theory
    public void add(int[] values) throws Exception {
        Calculator sut = new Calculator();
        assertThat(sut.add(values[0], values[1]), is(values[2]));
    }
}
