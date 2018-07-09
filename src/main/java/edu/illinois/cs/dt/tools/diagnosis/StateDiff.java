package edu.illinois.cs.dt.tools.diagnosis;

import edu.illinois.diaper.StateCapture;
import org.junit.runners.model.Statement;

import java.util.LinkedHashMap;

public class StateDiff {
    private final StateCapture sc;
    private final String testName;

    public StateDiff(final String testName) {
        this.testName = testName;

        sc = new StateCapture(testName);
    }

    public DiffContainer diff(final Statement statement) throws Throwable {
        final LinkedHashMap<String, Object> beforeCapture = new LinkedHashMap<>(sc.capture());
        statement.evaluate();
        final LinkedHashMap<String, Object> afterCapture = new LinkedHashMap<>(sc.capture());

        return new DiffContainer(testName, beforeCapture, afterCapture);
    }
}
