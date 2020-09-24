package javatest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import org.mockito.invocation.*;
import org.mockito.stubbing.*;

@RunWith(Enclosed.class)
public class MockitoTest {
    public static class ForMock {
        List<String> mock;
        @Before
        public void setUp() throws Exception {
            mock = mock(List.class);
        }

        @Test 
        public void mockitMockReturnsNull() throws Exception {
            assertThat(mock.get(0), is(nullValue()));
        }
        @Test 
        public void mockDontHaveHelloElement() throws Exception {
            assertThat(mock.contains("Hello"), is(false));
        }
    }
    
    public static class ForStub {
        List<String> stub;
        @Before
        public void setUp() throws Exception {
            stub = mock(List.class);
        }

        @Test 
        public void defineStub() throws Exception {
            when(stub.get(0)).thenReturn("Hello");
        }

        @Test(expected = IndexOutOfBoundsException.class)
        public void throwException() throws Exception {
            when(stub.get(0)).thenReturn("Hello");
            when(stub.get(1)).thenReturn("World");
            when(stub.get(2)).thenThrow(new IndexOutOfBoundsException());
            stub.get(2);
        }

        @Test(expected = RuntimeException.class)
        public void throwExceptionOnVoidReturn() throws Exception {
            doThrow(new RuntimeException()).when(stub).clear();
            stub.clear();
        }

        @Test
        public void ReturnHelloIfIntGiven() throws Exception {
            when(stub.get(anyInt())).thenReturn("Hello");
            assertThat(stub.get(0), is("Hello"));
            assertThat(stub.get(1), is("Hello"));
            assertThat(stub.get(200), is("Hello"));
        }
    }

    public static class ForStubVerify {

        @Test
        public void verifyClearCalledOnceAddHelloCalledTwiceAddWorldCalledNever() throws Exception {
            List<String> mock = mock(List.class);
            mock.clear();
            mock.add("Hello");
            mock.add("Hello");
            verify(mock).clear();
            verify(mock, times(2)).add("Hello");
            verify(mock, never()).add("World");
        }
    }

    public static class ForSpyMethod {
        @Test
        public void testUsingMockitoSpy() throws Exception {
            SpyExample sut = new SpyExample();
            Logger spy = spy(sut.logger);
            final StringBuilder infoLog = new StringBuilder();
            doAnswer(new Answer<Void>() {
                @Override
                public Void answer(InvocationOnMock invocation) throws Throwable {
                    infoLog.append(invocation.getArguments()[0]);
                    invocation.callRealMethod();
                    return null;
                }
            }).when(spy).info(anyString());
            sut.logger = spy;
            sut.doSomething();
            assertThat(infoLog.toString(), is("doSomething"));
        }
    }
}
