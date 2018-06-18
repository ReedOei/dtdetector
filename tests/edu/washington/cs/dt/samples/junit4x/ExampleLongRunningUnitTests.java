package edu.washington.cs.dt.samples.junit4x;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleLongRunningUnitTests {
    @Test
    public void testLongRunningTimesOut() throws Exception {
        Thread.sleep(5000);
    }
}
