package javatest;

import static org.junit.Assert.*;

import java.util.Date;

import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class MethodExtractExampleTest {
    @Test
    public void dateSetToCurrentDateWhenExecuteDoSomething() throws Exception {
        final Date current = new Date();
        MethodExtractExample sut = new MethodExtractExample() {
            @Override
            Date newDate() {
                return current;
            }
        };
        sut.doSomething();
        assertThat(sut.date, is(sameInstance(current)));
    }
}
