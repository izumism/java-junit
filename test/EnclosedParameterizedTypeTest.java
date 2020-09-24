package javatest;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.DataPoint;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;

@RunWith(Enclosed.class)
public class EnclosedParameterizedTypeTest {
    @RunWith(Theories.class)
    public static class parameterizedTestForInt {
        @DataPoint 
        public static int INT_PARAM_1 = 3;
        @DataPoint 
        public static int INT_PARAM_2 = 4;

        @Theory
        public void testMethodForIntParam(int param) {
            System.out.println("testMethodForIntParam " + param);
        }
    }

    @RunWith(Theories.class)
    public static class parameterizedTestForString {
        @DataPoint 
        public static String STRING_PARAM_1 = "Hello";
        @DataPoint
        public static String STRING_PARAM_2 = "World";

        @Theory
        public void testMethodForStringParam(String param) {
            System.out.println("testMethodForStringParam " + param);
        }
    }

    
    @RunWith(Theories.class)
    public static class parameterizedTestForMultiParams {
        @DataPoint 
        public static int INT_PARAM_1 = 3;
        @DataPoint 
        public static int INT_PARAM_2 = 4;

        @DataPoint 
        public static String STRING_PARAM_1 = "Hello";
        @DataPoint
        public static String STRING_PARAM_2 = "World";

        @Theory
        public void testMethodForMultipleParams(int intParam, String strParam) {
            System.out.println("int: " + intParam + " String: " + strParam);
        }
    }
}
