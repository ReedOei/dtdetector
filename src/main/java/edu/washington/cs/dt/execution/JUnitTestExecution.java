package edu.washington.cs.dt.execution;

import edu.illinois.cs.dt.tools.diagnosis.DiffContainer;
import edu.washington.cs.dt.util.JUnitTestResult;

import java.util.Map;
import java.util.Set;

public class JUnitTestExecution {
    private final Set<JUnitTestResult> results;
    private final Map<String, DiffContainer> stateDiffs;

    public JUnitTestExecution(final Set<JUnitTestResult> results,
                              final Map<String,DiffContainer> stateDiffs) {
        this.results = results;
        this.stateDiffs = stateDiffs;
    }

    public Set<JUnitTestResult> getResults() {
        return results;
    }

    public Map<String, DiffContainer> getStateDiffs() {
        return stateDiffs;
    }
}
