package edu.washington.cs.dt.tools;

import edu.washington.cs.dt.samples.junit4x.ExampleAbstractTestClass;
import edu.washington.cs.dt.samples.junit4x.ExampleGetTestsClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class UnitTestFinderTest {
    @Test
    public void getUnitTestsFromClass() {
        final List<String> tests = new UnitTestFinder().getUnitTestsFromClass(ExampleGetTestsClass.class);

        assertEquals(3, tests.size());
        assertThat(tests, hasItems("edu.washington.cs.dt.samples.junit4x.ExampleGetTestsClass.test2",
                        "edu.washington.cs.dt.samples.junit4x.ExampleGetTestsClass.test3",
                        "edu.washington.cs.dt.samples.junit4x.ExampleGetTestsClass.test1"));
    }

    @Test
    public void testDontGetAbstractClassTests() {
        final List<String> tests = new UnitTestFinder().getUnitTestsFromClass(ExampleAbstractTestClass.class);

        assertTrue(tests.isEmpty());
    }
}