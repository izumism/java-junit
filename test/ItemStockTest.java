package javatest;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;

@RunWith(Enclosed.class)
public class ItemStockTest {

    public static class CaseOfEmpty {
        ItemStock sut;

        @Before
        public void setUp() throws Exception {
            sut = new ItemStockImpl();
        }

        @Test
        public void size_Areturns0() throws Exception {
            assertThat(sut.size("A"), is(0));
        }

        @Test
        public void contains_AreturnsFalse() throws Exception {
            assertThat(sut.contains("A"), is(false));
        }
    }

    public static class CaseIfContainsOneAItem {
        ItemStock sut;

        @Before
        public void setUp() throws Exception {
            sut = new ItemStockImpl();
            sut.add("A", 1);
        }

        @Test
        public void sizeReturns1() throws Exception {
            assertThat(sut.size("A"), is(1));
        }

        @Test
        public void contains_AReturnsTrue() throws Exception {
            assertThat(sut.contains("A"), is(true));
        }
    }
}
