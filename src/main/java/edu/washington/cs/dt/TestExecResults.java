/**
 * Copyright 2012 University of Washington. All Rights Reserved.
 * @author Sai Zhang
 */
package edu.washington.cs.dt;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.washington.cs.dt.util.Globals;

public class TestExecResults {

    /* each item in the list represents one launch of JVM */
    private List<TestExecResult> executionRecords = new LinkedList<TestExecResult>();

    private TestExecResults() {
    }

    public static TestExecResults createInstance() {
        return new TestExecResults();
    }

    /* add the result from one JVM run */
    public void addExecutionResults(Map<String, OneTestExecResult> result) {
        TestExecResult r = new TestExecResult(result);
        this.executionRecords.add(r);
    }

    public List<TestExecResult> getExecutionRecords() {
        return this.executionRecords;
    }

    @Override
    public String toString() {
        // BE AWARE: If this is changed, you will also need to change how the Parallelization
        // handles time orders in dt-impact-tracers (currently in processFile()).
        StringBuilder sb = new StringBuilder();
        for (TestExecResult r : executionRecords) {
            sb.append(Globals.lineSep);
            sb.append("Pass: " + r.passingTestsInOrder.size() + ", Fail: " + r.failingTestsInOrder.size() + ", Error: "
                    + r.errorTestsInOrder.size() + ", Skipped: " + r.skippedTestsInOrder.size() + ", Ignored: " + r.ignoredTestsInOrder.size());
            sb.append(Globals.lineSep);
            sb.append(r.toString());
            sb.append(Globals.lineSep);
        }
        return sb.toString();
    }
}
