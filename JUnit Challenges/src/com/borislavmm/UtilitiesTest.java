package com.borislavmm;

import jdk.jshell.execution.Util;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

//@RunWith(Parameterized.class)
public class UtilitiesTest {

    private Utilities util;

    @org.junit.Before
    public void setup() {
        util = new Utilities();
    }
//
//    private Utilities util;
//    private char[] expected_ench;
//    private char[] source;
//    private int n;
//
//    public UtilitiesTest(char[] expected_ench, char[] source, int n) {
//        this.expected_ench = expected_ench;
//        this.source = source;
//        this.n = n;
//    }
//
//    @Parameterized.Parameters
//    public static Collection<Object> testConditions() {
//        return Arrays.asList(new Object[][]{
//                {new char[]{'c'}, new char[]{'a', 'b', 'c', 'd', 'e'}, 3},
//                {new char[]{'a', 'b', 'c', 'd', 'e'}, new char[]{'a', 'b', 'c', 'd', 'e'}, 10},
//                {null, null, 3333},
//                {new char[]{'a', 'b', 'c', 'd', 'e'}, new char[]{'a', 'b', 'c', 'd', 'e'}, 0},
//                {new char[]{'a', 'b', 'c', 'd', 'e'}, new char[]{'a', 'b', 'c', 'd', 'e'}, -5}
//        });
//    }
//
//    @Before
//    public void setup() {
//        util = new Utilities();
//    }



    @org.junit.Test
    public void everyNthChar() {
//        Utilities util = new Utilities();
//        assertArrayEquals(expected_ench, util.everyNthChar(source, n));
        assertArrayEquals(new char[]{'e','l'}, util.everyNthChar(new char[]{'h','e','l','l','o'}, 2));
        assertArrayEquals(new char[]{'h','e','l','l','o'}, util.everyNthChar(new char[]{'h','e','l','l','o'}, 10));
    }

    @org.junit.Test
    public void removePairs_Test() throws Exception {
//        Utilities util = new Utilities();
//        assertEquals("ABCDEF", util.removePairs("AAABBBBBCCCDEEEEFF"));

        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("AABCABDDEFF"));
        assertEquals(null, util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));

    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void converter() {
//        Utilities util = new Utilities();
//        assertEquals(0, util.converter(3, 0));
         new Utilities().converter(10, 0);
    }

    @org.junit.Test
    public void nullIfOddLength() {
        assertNull(new Utilities().nullIfOddLength("abc"));
        assertNotNull( new Utilities().nullIfOddLength("abcd"));
    }
}