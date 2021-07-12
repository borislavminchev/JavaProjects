package com.borislavmm;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.security.Policy;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UtilitiesTestParameterized {

    private Utilities util;

    private String input;
    private String output;

    public UtilitiesTestParameterized(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Before
    public void setup() {
        util = new Utilities();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
            {"ABCDEFF", "ABCDEF"},
            {"AB88EFFG","AB8EFG"},
            {"112233445566","123456"},
            {"A","A"}
        });
    }

    @org.junit.Test
    public void removePairs() throws Exception{
        assertEquals(output, util.removePairs(input));
    }
}
