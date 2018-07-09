package edu.washington.cs.dt.samples;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore
public class StateDiffSampleTest {
    private static int x = 0;

    @Test
    public void test1() {
        x = 4;
        assertEquals(4, x);
    }
}
