package edu.illinois.cs.dt.tools.diagnosis;

import com.reedoei.eunomia.collections.MapUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DiffContainer {
    private final Map<String, Diff> diffs = new HashMap<>();
    private final String testName;

    public DiffContainer(final String testName, final Map<String, Object> before, final Map<String, Object> after) {
        this.testName = testName;

        for (final String k : MapUtil.diff(before, after)) {
            diffs.put(k, new Diff(before.get(k), after.get(k)));
        }
    }

    public Optional<Diff> getDiff(final String fqFieldName) {
        return Optional.ofNullable(diffs.get(fqFieldName));
    }

    public Map<String, Diff> getDiffs() {
        return diffs;
    }

    public class Diff {
        private final Object before;
        private final Object after;

        private Diff(Object before, Object after) {
            this.before = before;
            this.after = after;
        }

        public Object getBefore() {
            return before;
        }

        public Object getAfter() {
            return after;
        }
    }
}
