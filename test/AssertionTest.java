package javatest;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.Ignore;

public class AssertionTest {
    @Test
    public void assertion() {
        String actual = "Hello" + " " + "World";
        assertThat(actual, is("Hello World"));
    }

    @Test
    public void assertNullvalue() {
        String actual = null;
        assertThat(actual, is(nullValue()));
    }

    @Test 
    public void assertNotnullValue() {
        String actual = "";
        assertThat(actual, is(not(nullValue())));
    }

    @Test
    public void assertNotNullValue() {
        String actual = "";
        assertThat(actual, is(notNullValue()));
    }

    @Test
    public void assertSameInstance() {
        Calculator expected = new Calculator();
        Calculator actual = expected;
        assertThat(actual, is(sameInstance(expected)));
    }

    @Test
    public void assertCalcualtorIsNotSerializerCompatible() {
        Calculator sut = new Calculator();
        assertThat(sut, is(not(instanceOf(Serializable.class))));
    }

    @Test
    public void assertHasItem() {
        List<Integer> sut = Arrays.asList(0, 1, 2, 3);
        assertThat(sut, hasItem(3));
    }

    @Test
    public void assertHasItems() {
        List<Integer> sut = Arrays.asList(0, 1, 2, 3);
        assertThat(sut, hasItems(3, 1));
    }

    @Test
    public void assertEmpty() {
        List<Integer> sut = new ArrayList<>();
        assertThat(sut, empty());
    }

    @Test
    public void assertHasSize() {
        List<Integer> sut = Arrays.asList(0, 1, 2, 3);
        assertThat(sut, hasSize(4));
    }

    @Test
    public void assertGreaterThan() {
        assertThat(1, greaterThan(0));
    }
 }
